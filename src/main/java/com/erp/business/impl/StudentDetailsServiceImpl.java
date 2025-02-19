package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.StudentDetailsService;
import com.erp.dto.DocumentDetailsRequest;
import com.erp.dto.DocumentDetailsResponse;
import com.erp.dto.DropDown;
import com.erp.dto.FeeDetailsRequest;
import com.erp.dto.FeeDetailsResponse;
import com.erp.dto.FileDTO;
import com.erp.dto.StudentDetailsRequest;
import com.erp.dto.StudentDetailsResponse;
import com.erp.entity.DocumentDetails;
import com.erp.entity.FeeDetails;
import com.erp.entity.StudentDetails;
import com.erp.repository.ClassDetailsRepository;
import com.erp.repository.SectionDetailsRepository;
import com.erp.repository.StudentDetailsRepository;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;

	@Autowired
	private ClassDetailsRepository classDetailsRepository;

	@Autowired
	private SectionDetailsRepository sectionDetailsRepository;

	@Override
	public long saveStudentDetails(StudentDetailsRequest studentDetailsRequest) {

		StudentDetails studentDetails = null;
		long studentId = 0;

		// System.out.println(" in save method---->>>"+studentDetailsRequest.getId());

		if (studentDetailsRequest != null) {
			if (studentDetailsRequest.getId() != null) { // Update
				// System.out.println("called for save for ID");
				studentDetails = getStudentDetails(studentDetailsRequest.getId());
			} else {
				studentDetails = new StudentDetails(); // create
				// System.out.println("called for save else ID");
			}
			studentDetails = convertStudentRequestToStudentDetailsEntity(studentDetailsRequest);
			studentDetails = studentDetailsRepository.save(studentDetails);
			if (studentDetails != null) {
				studentId = studentDetails.getId();
			}
		}
		return studentId;
	}

	// update
	private StudentDetails getStudentDetails(Long studentId) {
		System.out.println("called for update");
		Optional<StudentDetails> optStudentDetails = studentDetailsRepository.findById(studentId);
		if (optStudentDetails != null && optStudentDetails.get() != null) {
			return optStudentDetails.get();
		}
		return null;
	}

	private StudentDetails convertStudentRequestToStudentDetailsEntity(StudentDetailsRequest studentDetailsRequest) {

		StudentDetails studentDetails = new StudentDetails();
		BeanUtils.copyProperties(studentDetailsRequest, studentDetails);
		studentDetails.setBloodGroup(studentDetailsRequest.getBloodGroupName());
		FileDTO studentPhoto = studentDetailsRequest.getStudentPhoto();
		if (studentPhoto != null) {
			byte[] decodedByte = Base64.decodeBase64(studentPhoto.getBase64());
			studentDetails.setProfilePhoto(decodedByte);
		}

		// Fee List
		List<FeeDetails> feeDetailsList = new ArrayList<>();
		List<FeeDetailsRequest> fees = studentDetailsRequest.getFees();

		// Doc List
		List<DocumentDetails> documentDetailsList = new ArrayList<>();
		List<DocumentDetailsRequest> docs = studentDetailsRequest.getDocuments();

		if (fees != null && fees.size() > 0) {

			for (FeeDetailsRequest feeDetailsRequest : fees) {
				FeeDetails feeDetails = new FeeDetails();
				feeDetails.setAmountPaid(feeDetailsRequest.getAmountPaid());
				feeDetails.setPaidDate(feeDetailsRequest.getPaidDate());
				feeDetails.setTotalAmount(studentDetailsRequest.getTotalAmount());
				feeDetails.setNextDueDate(feeDetailsRequest.getNextDueDate());
				feeDetailsList.add(feeDetails);
				feeDetails.setStudentDetails(studentDetails);
			}

		}

		if (docs != null && docs.size() > 0) {
			for (DocumentDetailsRequest documentDetailsRequest : docs) {
				DocumentDetails documentDetails = new DocumentDetails();
				documentDetails.setDocumentName(documentDetailsRequest.getDocumentName());
				documentDetails.setDocumentNo(documentDetailsRequest.getDocumentNo());
				FileDTO docPhoto = documentDetailsRequest.getDocumentIdetificationPhoto();
				if(docPhoto != null) {
					byte[] decodedByte = Base64.decodeBase64(docPhoto.getBase64());
					documentDetails.setDocumentPhoto(decodedByte);
				}
				documentDetails.setStudentDetails(studentDetails);
				documentDetailsList.add(documentDetails);
			}
		}
		studentDetails.setFeeDetails(feeDetailsList);
		studentDetails.setDocumentDetails(documentDetailsList);
		return studentDetails;

	}

	@Override
	public List<StudentDetailsResponse> getStudentList() {

		// System.out.println("getStudentList---->>");
		List<StudentDetailsResponse> studentDetailsResponseList = new ArrayList<StudentDetailsResponse>();

		List<StudentDetails> studentList = studentDetailsRepository.findAll();

		if (studentList != null && !studentList.isEmpty()) {
			for (StudentDetails studentDetails : studentList) {
				double totalFeeAmount = 0.0;
				double amountPaid = 0.0;
				List<FeeDetailsResponse> feeDetailsResponsesList = new ArrayList<FeeDetailsResponse>();
				List<DocumentDetailsResponse> documentDetailsResponsesList = new ArrayList<DocumentDetailsResponse>();
				if (studentDetails != null) {

					StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
					studentDetailsResponse.setId(studentDetails.getId());
					studentDetailsResponse.setStudentName(studentDetails.getStudentName());

					studentDetailsResponse.setContactNo(studentDetails.getContactNo());
					studentDetailsResponse.setCity(studentDetails.getCity());
					studentDetailsResponse.setAge(studentDetails.getAge());
					studentDetailsResponse.setDob(studentDetails.getDob());
					studentDetailsResponse.setEmailId(studentDetails.getEmailId());
					studentDetailsResponse.setFatherName(studentDetails.getFatherName());
					studentDetailsResponse.setMotherName(studentDetails.getMotherName());
					studentDetailsResponse.setBloodGroup(studentDetails.getBloodGroup());
					long classId = studentDetails.getClassId();
					long sectionId = studentDetails.getSectionId();
					String className = classDetailsRepository.getClassNameById(classId);
					String sectionName = sectionDetailsRepository.getSectionNameById(sectionId);
					studentDetailsResponse.setClassId(classId);
					studentDetailsResponse.setSectionId(sectionId);
					studentDetailsResponse.setClassName(className);
					studentDetailsResponse.setSectionName(sectionName);
					DropDown classDropDown = new DropDown();
					classDropDown.setId(classId);
					classDropDown.setText(className);
					DropDown sectionDropDown = new DropDown();
					sectionDropDown.setId(sectionId);
					sectionDropDown.setText(sectionName);
					studentDetailsResponse.setClassDropDown(classDropDown);
					studentDetailsResponse.setSectionDropDown(sectionDropDown);
					studentDetailsResponse.setStudentPhoto(studentDetails.getProfilePhoto());

					for (FeeDetails feeDetails : studentDetails.getFeeDetails()) {
						FeeDetailsResponse feeDetailsResponse = new FeeDetailsResponse();
						feeDetailsResponse.setId(feeDetails.getId());
						feeDetailsResponse.setNextDueDate(feeDetails.getNextDueDate());
						feeDetailsResponse.setPaidDate(feeDetails.getPaidDate());
						feeDetailsResponse.setTotalAmount(feeDetails.getTotalAmount());
						totalFeeAmount = feeDetails.getTotalAmount();
						amountPaid = feeDetails.getAmountPaid() + amountPaid;// installments
						feeDetailsResponse.setAmountPaid(feeDetails.getAmountPaid());

						// calculate balance Amount and return status
						// Long
						// balanceAmount=feeDetailsRepository.getBalanceAmountForStudent(studentDetails.getId());

						// balanceAmount=totalFeeAmount-amountPaid;
						// System.out.println("fee details balance amount"+balanceAmount);
						feeDetailsResponsesList.add(feeDetailsResponse);

					}

					if (amountPaid == totalFeeAmount) {
						studentDetailsResponse.setFeeStatus("paid");
					} else {
						studentDetailsResponse.setFeeStatus("pending");
					}

					for (DocumentDetails documentDetails : studentDetails.getDocumentDetails()) {
						DocumentDetailsResponse documentDetailsResponse = new DocumentDetailsResponse();
						documentDetailsResponse.setDocumentName(documentDetails.getDocumentName());
						documentDetailsResponse.setDocumentNo(documentDetails.getDocumentNo());
						// System.out.println("get doc number"+documentDetails.getDocumentNo());
						documentDetailsResponse.setId(documentDetails.getId());
						documentDetailsResponse.setDocumentPhoto(documentDetails.getDocumentPhoto());
						documentDetailsResponse.setDocumentIdetificationPhoto(documentDetails.getDocumentPhoto());
						documentDetailsResponsesList.add(documentDetailsResponse);

					}
					studentDetailsResponse.setTotalAmount(totalFeeAmount);
					// studentDetailsResponse.setFeeStatus(null);
					studentDetailsResponse.setFees(feeDetailsResponsesList);
					studentDetailsResponse.setDocuments(documentDetailsResponsesList);
					studentDetailsResponseList.add(studentDetailsResponse);
				}
			}
		}
		return studentDetailsResponseList;
	}

	@Override
	public boolean deleteStudent(Long id) {
		if (id != null) {
			studentDetailsRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
