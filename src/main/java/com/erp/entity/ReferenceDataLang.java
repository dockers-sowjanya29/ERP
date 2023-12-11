package com.erp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ref_data_lang")
public class ReferenceDataLang {
	
		
		@Id
		@Column(name="REF_DATA_LANG_ID")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
	
		@Column(name="REF_DATA_ID")
		private Long refDataId;
		
		@Column(name="REF_DATA_LABEL")
		private String refDataLabel;
		
		@Column(name="LANG_TYPE")
		private String langType;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getRefDataId() {
			return refDataId;
		}

		public void setRefDataId(Long refDataId) {
			this.refDataId = refDataId;
		}

		public String getRefDataLabel() {
			return refDataLabel;
		}

		public void setRefDataLabel(String refDataLabel) {
			this.refDataLabel = refDataLabel;
		}

		public String getLangType() {
			return langType;
		}

		public void setLangType(String langType) {
			this.langType = langType;
		}
		
		
		
		
}
