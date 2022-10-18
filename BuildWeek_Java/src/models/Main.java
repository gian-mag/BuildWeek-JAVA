package models;

import models.classes.*;
import models.enums.StatoServizio;

public class Main {
    public static void main(String[] args) {
    }


    //? mezzi
    static void insertBus(Bus b){
        //mezzoDAO.save(b)
        Deposito d = new Deposito();
        d.setMezzo(b);
        d.setStatusMezzo(b.getStatus());
//        depositoDAO.save(d)
    }

    static  void toggleDeposito(int mezzoId){
//        Mezzo m = mezzoDAO.getById(mezzoId);
//        m.toggleStatus();
        //update
        Deposito d = new Deposito();
//        d.setMezzo(m);
//        d.setStatusMezzo(m.getStatus());
    }

    //? biglietti

    static void erogaBiglietto(Rivenditore r){
        Biglietto b = new Biglietto();
        b.setRivenditore(r);
    }

    static void erogaAbbonamento(int tesseraId, Rivenditore r){
//        Tessera t = TesseraDAO.getById(tesseraId);
//        if (TesseraDAO.getById(tesseraId)){
//            Abbonamento a = new Abbonamento();
//            a.setTessera(t);
//            a.setRivenditore(r);
//        }
    }

    static void compraAbbDaRivenditore(int tesseraId, Rivenditore r){
        erogaAbbonamento(tesseraId, r);
    }
    static void compraAbbDaDistributore(int tesseraId, Distributore r){
        if(r.getInServizio() == StatoServizio.IN_SERVIZIO){
            erogaAbbonamento(tesseraId, r);
        }else {
            System.out.println("distributore non attivo");
        }

    }
    static void compraBiglDaRivenditore(Rivenditore r){
       erogaBiglietto(r);
    }
    static void compraBiglDaDistributore(Distributore r){
        if(r.getInServizio() == StatoServizio.IN_SERVIZIO){
            erogaBiglietto(r);
        }else {
            System.out.println("distributore non attivo");
        }

    }

    static void erogaTessera(int userId){
//        Utente u = UtenteDAO.getById(userId);
        Tessera t = new Tessera();
//        t.setUtente(u);
    }

}

