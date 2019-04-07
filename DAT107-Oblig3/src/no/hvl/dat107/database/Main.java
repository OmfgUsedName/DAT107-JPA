package no.hvl.dat107.database;

import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;
import no.hvl.dat107.entity.Prosjekt;
import no.hvl.dat107.entity.Prosjektdeltagere;
import no.hvl.dat107.entity.ProsjektdeltagereId;

public class Main {

	static DatabaseEAO e;
	static TekstGrensesnitt t;

	public static void main(String[] args) {
		e = new DatabaseEAO();
		t = new TekstGrensesnitt();
		while (true) {
			t.skrivUtHovedMeny();
			switch (t.getMenyChoice()) {
			case 1: // Legg til
				leggTil();
				break;
			case 2: // Hent informasjon
				hent();
				break;
			case 3: // Oppdater
				oppdater();
				break;
			case 4: // avslutt
				slett();
				break;
			case 5:
				System.exit(0);
				break;
			}
		}
	}

	public static void hent() {
		t.skrivUtHentMeny();
		Ansatt ansatt;
		Avdeling avdeling;
		Prosjekt prosjekt;
		switch (t.getMenyChoice()) {
		case 1: // Hent ansatt med id
			ansatt = e.hentAnsatt(t.getInteger("Ansatt id: "));
			if (ansatt != null) {
				t.skrivUt(ansatt.toString());
			}
			break;
		case 2: // Hent ansatt med brukernavn
			ansatt = e.hentAnsatt(t.getString("Brukernavn: "));
			if (ansatt != null) {
				t.skrivUt(ansatt.toString());
			}
			break;
		case 3: // Hent alle ansatte
			t.skrivUtAlleAnsatte(e.hentAlleAnsatte());
			break;
		case 4: // Hent avdeling med id
			avdeling = e.hentAvdeling((t.getInteger("Avdeling id: ")));
			if (avdeling != null) {
				t.skrivUt(avdeling.toString());
			}
			break;
		case 5: // Hent alle ansatte på avdeling med id
			avdeling = e.hentAvdeling(t.getInteger("Avdeling id: "));
			t.skrivUtAlleAnsatte(avdeling.getListe());
			break;
		case 6: // Alle prosjektinfo---liste av deltagere med rolle og timer---totalt timetall.
			prosjekt = e.hentProsjekt(t.getInteger("Prosjekt id: "));
			t.skrivUtProsjektInformasjon(prosjekt);
			break;
		}
	}

	public static void oppdater() {
		t.skrivUtOppdaterMeny();
		Ansatt a;
		switch (t.getMenyChoice()) {
		case 1: // ansattes stilling
			a = e.hentAnsatt(t.getInteger("Skriv inn ansattes id: "));
			a.setStilling(t.getString("Skriv inn ny stilling: "));
			e.merge(a);
			break;
		case 2: // ansattes lonn
			a = e.hentAnsatt(t.getInteger("Skriv inn ansattes id: "));
			a.setLonn(t.getInteger("Skriv inn ny lonn: "));
			e.merge(a);
			break;
		case 3: // ansattes avdeling
			a = e.hentAnsatt(t.getInteger("Skriv inn ansattes id: "));
			a.setAvdeling(t.getInteger("Skriv inn ny avdeling: "));
			e.merge(a);
			break;
		case 4: // Prosjektdeltagelse timer
			ProsjektdeltagereId id = new ProsjektdeltagereId();
			id.setAnsatt_id(t.getInteger("Ansatt id: "));
			id.setProsjekt_id(t.getInteger("Prosjekt id: "));
			Prosjektdeltagere d = e.hentProsjektdeltagere(id);
			d.setTimer(t.getInteger("Nye timer:"));
			e.merge(d);
			break;
		}
	}

	public static void leggTil() {
		t.skrivUtLeggTilMeny();
		switch (t.getMenyChoice()) {
		case 1: // Ansatt
			Ansatt ansatt = t.getAnsatt();
			e.leggTil(ansatt);
			break;
		case 2: // Avdeling
			Avdeling avdeling = t.getAvdeling();
			e.leggTil(avdeling);
			break;
		case 3: // Prosjekt
			Prosjekt prosjekt = t.getProsjekt();
			e.leggTil(prosjekt);
			break;
		case 4: // Prosjektdeltagelse
			Prosjektdeltagere prosjektdeltagere = t.getProsjektdeltagere();
			e.leggTil(prosjektdeltagere);
			break;
		}
	}

	public static void slett() {
		t.skrivUtSlettMeny();
		switch (t.getMenyChoice()) {
		case 1: // Ansatt
			e.slettAnsatt(t.getInteger("Ansatt id: "));
			break;
		case 2: // Avdeling
			e.slettAvdeling(t.getInteger("Avdeling id:"));
			break;
		case 3: // Prosjekt
			e.slettProsjekt(t.getInteger("Prosjekt id: "));
			break;
		case 4: // Prosjektdeltagelse
			ProsjektdeltagereId id = new ProsjektdeltagereId();
			id.setAnsatt_id(t.getInteger("Ansatt id: "));
			id.setProsjekt_id(t.getInteger("Prosjekt id: "));
			e.slettProsjektdeltagere(id);
			break;
		}
	}

}
