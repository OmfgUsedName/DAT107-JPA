package no.hvl.dat107.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "ansatt")
public class Ansatt {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private Date ansatt;
	private String stilling;
	private int lonn;
	private int avdeling;
	
	@JoinColumn(name = "avdeling", updatable = false, insertable = false)
	@ManyToOne(optional=false)
	private Avdeling avd;
	
	public Date getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(Date ansatt) {
		this.ansatt = ansatt;
	}

	public Avdeling getAvd() {
		return avd;
	}

	public void setAvd(Avdeling avd) {
		this.avd = avd;
	}

	public Ansatt() {
		
	}
	
	public Ansatt(String brukernavn, String fornavn, String etternavn, Date ansatt, String stilling, int lonn, int avdeling) {
		super();
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansatt = ansatt;
		this.stilling = stilling;
		this.lonn = lonn;
		this.avdeling = avdeling;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Date getDato() {
		return ansatt;
	}

	public void setDato(Date dato) {
		ansatt = dato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getLonn() {
		return lonn;
	}

	public void setLonn(int lonn) {
		this.lonn = lonn;
	}

	public int getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(int avdeling) {
		this.avdeling = avdeling;
	}

	@Override 
	public String toString() {
		return "Id: " + this.id + ", "+"Brukernavn: " + this.brukernavn + ", "+"fornavn: " + this.fornavn + ", "+"Etternavn: " 
	+ this.etternavn + ", "+"Ansatt den: " + this.ansatt + ", "+"Stilling: " + this.stilling + ", "+"Lonn: " + this.lonn + ", "+"Avdeling: " + this.avdeling;
	}
}
