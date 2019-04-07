package no.hvl.dat107.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "avdeling")
public class Avdeling {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int avdeling_id;
	private String avdeling_navn;
	private int avdeling_sjef;
	
	@OneToMany(mappedBy = "avd", fetch = FetchType.LAZY)
	private List<Ansatt> liste;

	public List<Ansatt> getListe() {
		return liste;
	}

	public void setListe(List<Ansatt> liste) {
		this.liste = liste;
	}

	public Avdeling() {

	}

	public Avdeling(String avdeling_navn, int avdeling_sjef) {
		super();
		this.avdeling_navn = avdeling_navn;
		this.avdeling_sjef = avdeling_sjef;
	}

	public int getAvdeling_id() {
		return avdeling_id;
	}

	public void setAvdeling_id(int avdeling_id) {
		this.avdeling_id = avdeling_id;
	}

	public String getAvdeling_navn() {
		return avdeling_navn;
	}

	public void setAvdeling_navn(String avdeling_navn) {
		this.avdeling_navn = avdeling_navn;
	}

	public int getAvdeling_sjef() {
		return avdeling_sjef;
	}

	public void setAvdeling_sjef(int avdeling_sjef) {
		this.avdeling_sjef = avdeling_sjef;
	}

	@Override
	public String toString() {
		return "Id: " + this.avdeling_id + ", " + "Navn: " + this.avdeling_navn + ", " + "Sjef: " + this.avdeling_sjef;
	}
}
