//
//  NewsPresenter.swift
//  Colectiv
//
//  Created by Lobont Andrei on 19/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class NewsPresenter {
    private weak var view: NewsView?
    private weak var navigation: NewsNavigation?
    private var news: [News] = []
    
    init(view: NewsView, navigation: NewsNavigation) {
        self.view = view
        self.navigation = navigation
    }
    
    func viewDidLoad() {
        populateNews()
    }
    
    func getNumberOfNews() -> Int {
        return news.count
    }
    
    func getNews(at index: Int) -> News {
        return news[index]
    }
    
    func newsAt(index: Int) {
        navigation?.navigateToNews(with: news[index])
    }
    
    private func populateNews() {
        let n1: News = News(headLine: "Listele de vot valabile pentru alegerile din 23 si 28 ianuarie 2020", description: "Au drept de vot cadrele didactice şi de cercetare titulare, angajate cu contract individual de muncă pe perioadă nedeterminată.\n 23 ianuarie 2020 (alegeri pentru Director Departament, Consiliul Departamentului, Consiliul Facultății)", text: " Au drept de vot cadrele didactice şi de cercetare titulare, angajate cu contract individual de muncă pe perioadă nedeterminată.\n 23 ianuarie 2020 (alegeri pentru Director Departament, Consiliul Departamentului, Consiliul Facultății)", image: "")
        let n2: News = News(headLine: "Examenul de certificare a competențelor profesionale pentru Programul postuniversitar de formare și dezvoltare profesională continuă în Informatică, sesiunea februarie 2020", description: "În data de 22 februarie 2020, ora 15:00, se organizează o nouă sesiune de certificare a competenţelor profesionale din cadrul Programului postuniversitar de formare și dezvoltare profesională în Informatică. Această sesiune este organizata doar pentru acei studenți ai programului postuniversitar care au toate creditele la disciplinele din planul de învățământ (au acumulat 113 credite) și care mai trebuie să susțină examenul de certificare a competențelor profesionale.\n Înscrierea (la secretariatul Facultății de Matematică și Informatică, str. M. Kogălniceanu, nr. 1, et. 1, sala 143) se face în data de 20 februarie 2020, între orele 9:00 – 12:00.", text: "În data de 22 februarie 2020, ora 15:00, se organizează o nouă sesiune de certificare a competenţelor profesionale din cadrul Programului postuniversitar de formare și dezvoltare profesională în Informatică. Această sesiune este organizata doar pentru acei studenți ai programului postuniversitar care au toate creditele la disciplinele din planul de învățământ (au acumulat 113 credite) și care mai trebuie să susțină examenul de certificare a competențelor profesionale.\n Înscrierea (la secretariatul Facultății de Matematică și Informatică, str. M. Kogălniceanu, nr. 1, et. 1, sala 143) se face în data de 20 februarie 2020, între orele 9:00 – 12:00.", image: "")
        let n3: News = News(headLine: "Concursuri naționale pentru burse de studii sau cercetare în străinătate -- FSEGA", description: "Ministerul Educaţiei și Cercetării, prin Agenţia de Credite şi Burse de Studii, anunţă lansarea concursurilor naţionale pentru acordarea burselor de studii sau cercetare în străinătate, oferite de alte state în baza documentelor de colaborare bilaterală sau în mod unilateral, pentru anul universitar 2020/2021. \n Persoanele care doresc să obţină o bursă de studii în străinătate oferită de Ministerul Educaţiei și Cercetării, prin Agenția de Credite și Burse de Studii, trebuie să participe la concursurile naţionale pentru acordarea burselor de studii în străinătate.\n Informații privind ofertele pentru anul universitar 2020/2021 (condiții de eligibilitate, termene limită de transmitere a dosarelor, numărul și tipul burselor oferite etc.) se găsesc la https://roburse.ro/burse-de-studii/bursa-acord-bilateral/", text: "Ministerul Educaţiei și Cercetării, prin Agenţia de Credite şi Burse de Studii, anunţă lansarea concursurilor naţionale pentru acordarea burselor de studii sau cercetare în străinătate, oferite de alte state în baza documentelor de colaborare bilaterală sau în mod unilateral, pentru anul universitar 2020/2021. \n Persoanele care doresc să obţină o bursă de studii în străinătate oferită de Ministerul Educaţiei și Cercetării, prin Agenția de Credite și Burse de Studii, trebuie să participe la concursurile naţionale pentru acordarea burselor de studii în străinătate.\n Informații privind ofertele pentru anul universitar 2020/2021 (condiții de eligibilitate, termene limită de transmitere a dosarelor, numărul și tipul burselor oferite etc.) se găsesc la https://roburse.ro/burse-de-studii/bursa-acord-bilateral/", image: "")
        let n4: News = News(headLine: "Start inscrieri concurs Hackaton – POCU 109172", description: "S-a dat startul etapei de inscrieri pentru concursul de tip hackathon pe care echipa proiectului POCU 109172 il va organiza in anul 2020 si la care pot participa exclusiv studentii inscrisi in acest proiect (in anul universitar 2018-2019 si cei care vor fi selectati in anul universitar 2019-2020). Concursul este dotat cu premii in bani (premiul I – 25000 lei, premiul II – 15000 lei si premiul III – 10000 lei) si este primul organizat de catre UBB intr-o asemenea formula. \n Inscrierea se poate face la adresa: https://forms.gle/EQ7bTRmenZ8vG87M7 pana cel tarziu la data de 3 decembrie 2019. Pentru a parcurge toti pasii din formularul de inscriere este necesara parcurgerea Regulamentului concursului de tip hackathon care a fost publicat la adresa: http://www.cs.ubbcluj.ro/POCU109172/Regulament%20concurs%20hackathon_FINAL.pdf", text: "S-a dat startul etapei de inscrieri pentru concursul de tip hackathon pe care echipa proiectului POCU 109172 il va organiza in anul 2020 si la care pot participa exclusiv studentii inscrisi in acest proiect (in anul universitar 2018-2019 si cei care vor fi selectati in anul universitar 2019-2020). Concursul este dotat cu premii in bani (premiul I – 25000 lei, premiul II – 15000 lei si premiul III – 10000 lei) si este primul organizat de catre UBB intr-o asemenea formula. \n Inscrierea se poate face la adresa: https://forms.gle/EQ7bTRmenZ8vG87M7 pana cel tarziu la data de 3 decembrie 2019. Pentru a parcurge toti pasii din formularul de inscriere este necesara parcurgerea Regulamentului concursului de tip hackathon care a fost publicat la adresa: http://www.cs.ubbcluj.ro/POCU109172/Regulament%20concurs%20hackathon_FINAL.pdf", image: "")
        let n5: News = News(headLine: "SHOCKING! Facebooks goes broke!", description: "Facebook CEO Mark Zuckerberg is desperate", text: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum", image: "")
        let n6: News = News(headLine: "Invitație la ROSE Days – Eveniment în cadrul proiectului ROSE al Facultății de Matematică și Informatică", description: "Studenții anului I (specializările în limba română, engleză și germană) sunt invitați să participe la activitățile organizate pentru ei în cadrul proiectului ROSE – STAY ! al Facultății de Matematică și Informatică. Evenimentul cuprinde expuneri motivaționale (prezentate de speakeri cu mare experiență) și activități de dezvoltare personală, distribuite în cele două zile ale evenimentului. \n Vă așteptăm cu drag! \n Decanatul Facultății de Matematică și Informatică", text: "Studenții anului I (specializările în limba română, engleză și germană) sunt invitați să participe la activitățile organizate pentru ei în cadrul proiectului ROSE – STAY ! al Facultății de Matematică și Informatică. Evenimentul cuprinde expuneri motivaționale (prezentate de speakeri cu mare experiență) și activități de dezvoltare personală, distribuite în cele două zile ale evenimentului. \n Vă așteptăm cu drag! \n Decanatul Facultății de Matematică și Informatică", image: "")
        let n7: News = News(headLine: "Workshop-uri de inovare", description: "Asociația Studențească de Antreprenoriat ”Iuliu Hațieganu” din cadrul UMF Cluj-Napoca organizează în perioada 8-23 octombrie o serie de workshop-uri dedicate studenților din universitățile clujene. Aceste workshop-uri sunt gratuie și au ca scop formarea și dezvoltarea cunoștințelor antreprenoriale în rândul studenților. Este încurajată participarea studenților din cadrul tuturor universităților clujene pentru a facilita schimbul de idei și crearea de colaborări.", text: "Asociația Studențească de Antreprenoriat ”Iuliu Hațieganu” din cadrul UMF Cluj-Napoca organizează în perioada 8-23 octombrie o serie de workshop-uri dedicate studenților din universitățile clujene. Aceste workshop-uri sunt gratuie și au ca scop formarea și dezvoltarea cunoștințelor antreprenoriale în rândul studenților. Este încurajată participarea studenților din cadrul tuturor universităților clujene pentru a facilita schimbul de idei și crearea de colaborări.", image: "")
        news = [n1, n2, n3, n4, n5, n6, n7]
    }
}