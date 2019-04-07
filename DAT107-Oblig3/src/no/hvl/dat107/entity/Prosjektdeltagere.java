package no.hvl.dat107.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "prosjektdeltagere")
public class Prosjektdeltagere {

	@EmbeddedId
	private ProsjektdeltagereId ProsjektdeltagereId;
	private String rolle;
	private int timer;
	
	@JoinColumn(name = "prosjekt_id", updatable = false, insertable = false)
	@ManyToOne(optional=false)
	private Prosjekt pro;

	public Prosjektdeltagere() {

	}

	public Prosjektdeltagere(ProsjektdeltagereId prosjektdeltagereid, String rolle, int timer) {
		super();
		this.ProsjektdeltagereId = prosjektdeltagereid;
		this.rolle = rolle;
		this.timer = timer;
	}

	public String getRolle() {
		return rolle;
	}

	public ProsjektdeltagereId getProsjektdeltagereId() {
		return ProsjektdeltagereId;
	}

	public void setProsjektdeltagereId(ProsjektdeltagereId prosjektdeltagereId) {
		ProsjektdeltagereId = prosjektdeltagereId;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	@Override
	public String toString() {
		return "Prosjekt Id: " + this.ProsjektdeltagereId.getProsjekt_id() + ", " + "Ansatt id: " + this.ProsjektdeltagereId.getAnsatt_id() + ", " + "Rolle: "
				+ this.rolle + ", " + "Timar: " + this.timer;
	}
}
