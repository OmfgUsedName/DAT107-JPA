package no.hvl.dat107.database;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;
import no.hvl.dat107.entity.Prosjekt;
import no.hvl.dat107.entity.Prosjektdeltagere;
import no.hvl.dat107.entity.ProsjektdeltagereId;

public class TekstGrensesnitt {

	private Scanner tastatur = new Scanner(System.in);

	public int getMenyChoice() {
		return Integer.parseInt(tastatur.nextLine());
	}

	public void skrivUtHovedMeny() {
		System.out.println("---Hovedmeny---");
		System.out.println("1. Legg til ny...");
		System.out.println("2. Hent informasjon om...");
		System.out.println("3. Oppdater informasjon om...");
		System.out.println("4. Slett...");
		System.out.println("5. Avslutt");
	}

	public void skrivUtLeggTilMeny() {
		System.out.println("---Legg Til---");
		System.out.println("1. Ansatt");
		System.out.println("2. Avdeling");
		System.out.println("3. Prosjekt");
		System.out.println("4. Prosjektdeltagelse");
	}

	public void skrivUtOppdaterMeny() {
		System.out.println("---Oppdater---");
		System.out.println("1. Ansattes stilling");
		System.out.println("2. Ansattes lonn");
		System.out.println("3. Ansattes avdeling");
		System.out.println("4. Prosjektdeltagelse timer");
	}

	public void skrivUtHentMeny() {
		System.out.println("---Hent---");
		System.out.println("1. Ansatte med id");
		System.out.println("2. Ansatte med brukernavn");
		System.out.println("3. Alle ansatte");
		System.out.println("4. Avdeling med id");
		System.out.println("5. Alle ansatte på avdeling");
		System.out.println("6. Prosjekt informasjon");
	}

	public void skrivUtSlettMeny() {
		System.out.println("---Slett---");
		System.out.println("1. Ansatt");
		System.out.println("2. Avdeling");
		System.out.println("3. Prosjekt");
		System.out.println("4. Prosjektdeltagelse");
	}

	public String getString(String utskrift) {
		System.out.println(utskrift);
		return tastatur.nextLine();
	}

	public int getInteger(String utskrift) {
		System.out.println(utskrift);
		return Integer.parseInt(tastatur.nextLine());
	}

	public void skrivUtAlleAnsatte(List<Ansatt> liste) {
		for (Ansatt a : liste) {
			skrivUt(a.toString());
		}
	}

	public void skrivUtProsjektInformasjon(Prosjekt prosjekt) {
		System.out.println(prosjekt);
		for (Prosjektdeltagere d : prosjekt.getListe()) {
			System.out.println("Ansatt id: " + d.getProsjektdeltagereId().getAnsatt_id() + ", Rolle: " + d.getRolle()
					+ ", Timer: " + d.getTimer());
		}
		int totalt = prosjekt.getListe().stream().mapToInt(x -> x.getTimer()).sum();
		System.out.println("Prosjektet har totalt brukt " + totalt + " timer");
	}

	public Ansatt getAnsatt() {
		Ansatt a = new Ansatt();
		System.out.println("Brukernavn: ");
		a.setBrukernavn(tastatur.nextLine());
		System.out.println("Fornavn: ");
		a.setFornavn(tastatur.nextLine());
		System.out.println("Etternavn: ");
		a.setEtternavn(tastatur.nextLine());
		System.out.println("Dato(format yyyy-mm-dd): ");
		a.setDato(Date.valueOf(tastatur.nextLine()));
		System.out.println("Lonn: ");
		a.setLonn(Integer.parseInt(tastatur.nextLine()));
		System.out.println("Stilling: ");
		a.setStilling(tastatur.nextLine());
		System.out.println("Avdeling: ");
		a.setAvdeling(Integer.parseInt(tastatur.nextLine()));
		return a;
	}

	public Avdeling getAvdeling() {
		Avdeling a = new Avdeling();
		System.out.println("Avdelingsavn: ");
		a.setAvdeling_navn(tastatur.nextLine());
		System.out.println("Avdelingssjef: ");
		a.setAvdeling_sjef(Integer.parseInt(tastatur.nextLine()));
		return a;
	}

	public Prosjekt getProsjekt() {
		Prosjekt p = new Prosjekt();
		System.out.println("Prosjektnavn: ");
		p.setProsjekt_navn(tastatur.nextLine());
		System.out.println("Prosjektbeskrivelse: ");
		p.setProsjekt_beskrivelse(tastatur.nextLine());
		;
		return p;
	}

	public Prosjektdeltagere getProsjektdeltagere() {
		Prosjektdeltagere p = new Prosjektdeltagere();
		ProsjektdeltagereId id = new ProsjektdeltagereId();
		System.out.println("Ansatt id: ");
		id.setAnsatt_id(Integer.parseInt(tastatur.nextLine()));
		System.out.println("Prosjekt id:");
		id.setProsjekt_id(Integer.parseInt(tastatur.nextLine()));
		p.setProsjektdeltagereId(id);
		System.out.println("Rolle: ");
		p.setRolle(tastatur.nextLine());
		System.out.println("Timer: ");
		p.setTimer(Integer.parseInt(tastatur.nextLine()));
		return p;
	}

	public void skrivUt(String s) {
		System.out.println(s);
	}
}
