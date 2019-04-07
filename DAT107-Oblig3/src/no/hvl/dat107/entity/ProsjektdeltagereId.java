package no.hvl.dat107.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProsjektdeltagereId implements Serializable {

	@Column(name = "prosjekt_id")
	private int prosjekt_id;
	@Column(name = "ansatt_id")
	private int ansatt_id;
	
	public ProsjektdeltagereId() {
		
	}

	public void setProsjekt_id(int prosjekt_id) {
		this.prosjekt_id = prosjekt_id;
	}


	public void setAnsatt_id(int ansatt_id) {
		this.ansatt_id = ansatt_id;
	}


	public int getProsjekt_id() {
		return prosjekt_id;
	}

	public int getAnsatt_id() {
		return ansatt_id;
	}
	
	@Override
	public boolean equals(Object o) {
	       if (this == o) return true;
	        if (!(o instanceof ProsjektdeltagereId)) return false;
	        ProsjektdeltagereId that = (ProsjektdeltagereId) o;
	        return Objects.equals(getProsjekt_id(), that.getProsjekt_id()) &&
	                Objects.equals(getAnsatt_id(), that.getAnsatt_id());
	}
	
}
