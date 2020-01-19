import {Component, Input, OnInit} from '@angular/core';

import {AddNewsItemComponent} from '../add-news-item/add-news-item.component';
import {NewsItem} from '../../../model/News';



@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  constructor() { }
  news: NewsItem[];
  showAddForm = false;
  showAddBtn = true;

  ngOnInit() {
    this.news = [
      {
        id: 1,
        title: 'Acetona',
        text: 'Acetona (cunoscută și sub denumirea de propanonă sau dimetilcetonă) este cea mai simplă cetonă. ' +
          'Este un lichid incolor cu miros caracteristic, fiind utilizat ca solvent organic și ca reactant' +
          ' într-o serie de procese de termoliză și reacții de sinteză în chimia organică. Ea face parte din ' +
          'grupa cetonelor, caracteristic pentru structura acetonei este gruparea carbonilică de care se leagă două grupări metil.',
        multimedia: './assets/pictures/800px-Aceton.svg.png',
        createdOn: '22.10.2019'
      },
      {
        id: 2,
        title: 'Calculatorul',
        text: 'Un calculator, numit și sistem de calcul, computer sau ordinator, este o mașină de prelucrat date și informații conform' +
          ' unei liste de instrucțiuni numită program. În zilele noastre calculatoarele se construiesc în mare majoritate din componente ' +
          'electronice și de aceea cuvântul „calculator” înseamnă de obicei un calculator electronic. Calculatoarele ' +
          'care sunt programabile ' +
          'liber și pot, cel puțin în principiu, prelucra orice fel de date sau informații se numesc universale (engleză general purpose,' +
          ' pentru ' +
          'scopuri generale). Calculatoarele actuale nu sunt doar mașini de prelucrat informații, ci și dispozitive care ' +
          'facilitează comunicația ' +
          'între doi sau mai mulți utilizatori, de exemplu sub formă de numere, text, imagini, sunet sau video sau ' +
          'chiar toate deodată (multimedia).\n' +
          '\n' +
          'Știința prelucrării informațiilor cu ajutorul calculatoarelor se numește informatică (engleză Computer Science).' +
          ' Tehnologia necesară ' +
          'pentru folosirea lor poartă numele Tehnologia Informației, prescurtat TI sau IT (de la termenul englezesc ' +
          'Information Technology).\n' +
          '\n' +
          'În principiu, orice calculator care deține un anumit set minimum de funcții (altfel spus, care poate ' +
          'emula o mașină Turing) poate îndeplini funcțiile oricărui alt asemenea calculator, indiferent că este vorba ' +
          'de un PDA sau de un supercalculator. Această compatibilitate a condus la folosirea calculatoarelor cu arhitecturi ' +
          'asemănătoare pentru cele mai diverse activități, de la calculul salarizării personalului unei companii până la ' +
          'controlul roboților industriali sau medicali (calculatoare universale).',
        multimedia: './assets/pictures/1280px-Desktop_computer_clipart_-_Yellow_theme.svg.png',
        createdOn: '28.10.2019'
      },
      {
        id: 3,
        title: 'Informatica',
        text: 'Termenul informatică desemnează știința procesării sistematice a informației, în special a procesării' +
          ' cu ajutorul calculatoarelor. Termenul englezesc corespunzător este Computer Science (știința calculatoarelor).\n' +
          '\n' +
          'Istoric, informatica s-a dezvoltat ca știință din matematică, în timp ce dezvoltarea primelor calculatoare' +
          ' își are originea în electrotehnică și telecomunicații. De aceea, calculatorul reprezintă doar dispozitivul' +
          ' pe care sunt implementate conceptele teoretice. Informaticianul olandez Edsger Dijkstra afirma: ' +
          '"În informatică ai de-a face cu calculatorul, așa cum ai în astronomie cu telescopul".\n' +
          '\n' +
          'A nu se confunda informatica nici cu Tehnologia informației și nici cu teoria informației.' +
          'Termenul informatică provine din alăturarea cuvintelor informație și matematică. Alte surse susțin că provine' +
          ' din combinația informație și automatică. Istoria informaticii începe înainte de momentul apariției ' +
          'computerului digital. Înainte de anul 1920, termenul de "computer" se referea în limba engleză la o persoană' +
          ' care efectua calcule (un funcționar). Primii cercetători în ceea ce avea să se numească informatică, cum sunt ' +
          'Kurt Gödel, Alonzo Church și Alan Turing, au fost interesați de problema computațională: ce informații ar putea ' +
          'un funcționar uman să calculeze având hârtie și creion, prin urmărirea pur și simplu a unei liste de instrucțiuni, ' +
          'atât timp cât este necesar, fără să fie nevoie ca el să fie inteligent sau să presupună capacități intuitive. Una ' +
          'din motivațiile acestui proiect a fost dorința de a proiecta și realiza "mașini computaționale" care să automatizeze' +
          ' munca, deseori plictisitoare și nu lipsită de erori, a unui calculator sau computer uman.\n' +
          '\n' +
          'În perioada anilor 1970, când mașinile computaționale au cunoscut o evoluție accelerată, termenul de "computer"' +
          ' și-a modificat semnificația, referindu-se de acum mai degrabă la mașini, decât la predecesorii săi umani.',
        multimedia: './assets/pictures/800px-Alan_Turing_cropped.jpg',
        createdOn: '30.10.2019'
      },
      {
        id: 4,
        title: 'Compiler',
        text: 'A compiler is a computer program that translates computer code written in one programming language (the ' +
          'source language) into another language (the target language). The name compiler is primarily used for programs' +
          ' that translate source code from a high-level programming language to a lower level language (e.g., assembly ' +
          'language, object code, or machine code) to create an executable program.[1][2]:p1\n' +
          '\n' +
          'However, there are many different types of compilers. If the compiled program can run on a computer whose CPU ' +
          'or operating system is different from the one on which the compiler runs, the compiler is a cross-compiler. A ' +
          'bootstrap compiler is written in the language that it intends to compile. A program that translates from a ' +
          'low-level language to a higher level one is a decompiler. A program that translates between high-level languages ' +
          'is usually called a source-to-source compiler or transpiler. A language rewriter is usually a program that' +
          ' translates the form of expressions without a change of language. The term compiler-compiler refers to tools' +
          ' used to create parsers that perform syntax analysis.\n' +
          '\n' +
          'A compiler is likely to perform many or all of the following operations: preprocessing, lexical analysis,' +
          ' parsing, semantic analysis (syntax-directed translation), conversion of input programs to an intermediate ' +
          'representation, code optimization and code generation. Compilers implement these operations in phases that ' +
          'promote efficient design and correct transformations of source input to target output. Program faults caused by' +
          ' incorrect compiler behavior can be very difficult to track down and work around; therefore, compiler implementers ' +
          'invest significant effort to ensure compiler correctness.[3]\n' +
          '\n' +
          'Compilers are not the only language processor used to transform source programs. An interpreter is computer software ' +
          'that transforms and then executes the indicated operations.[2]:p2 The translation process influences the design of ' +
          'computer languages which leads to a preference of compilation or interpretation. In practice, an interpreter can be ' +
          'implemented for compiled languages and compilers can be implemented for interpreted languages.',
        multimedia: './assets/pictures/800px-Compiler.svg.png',
        createdOn: '22.11.2019'
      },
      {
        id: 5,
        title: 'Carrot',
        text: 'The carrot (Daucus carota subsp. sativus) is a root vegetable, usually orange in colour, though purple, black, red, white, and yellow cultivars exist.[1] They are a domesticated form of the wild carrot, Daucus carota, native to Europe and Southwestern Asia. The plant probably originated in Persia and was originally cultivated for its leaves and seeds. The most commonly eaten part of the plant is the taproot, although the stems and leaves are eaten as well. The domestic carrot has been selectively bred for its greatly enlarged, more palatable, less woody-textured taproot.\n' +
          '\n' +
          'The carrot is a biennial plant in the umbellifer family Apiaceae. At first, it grows a rosette of leaves while building up the enlarged taproot. Fast-growing cultivars mature within three months (90 days) of sowing the seed, while slower-maturing cultivars need a month longer (120 days). The roots contain high quantities of alpha- and beta-carotene, and are a good source of vitamin K and vitamin B6, but the belief that eating carrots improves night vision is a myth put forward by the British in World War II to mislead the enemy about their military capabilities.\n' +
          '\n' +
          'The United Nations Food and Agriculture Organization (FAO) reports that world production of carrots and turnips (these plants are combined by the FAO) for the calendar year 2013 was 37.2 million tonnes; almost half (~45%) were grown in China. Carrots are widely used in many cuisines, especially in the preparation of salads, and carrot salads are a tradition in many regional cuisines.',
        multimedia: './assets/pictures/1280px-Vegetable-Carrot-Bundle-wStalks.jpg',
        createdOn: '15.11.2019'
      },
      {
        id: 6,
        title: 'Atom',
        text: 'Un atom este cea mai mică unitate constitutivă a materiei comune care are proprietățile unui element chimic.[1] Orice solid, lichid, gaz și plasmă este compus din atomi neutri sau ionizați. Atomii sunt foarte mici; dimensiuni tipice sunt în jur de 100 pm (a zecea miliardime dintr-un metru).[2] Atomii nu au limite bine definite, și există diferite moduri de a defini dimensiunea, care dau fiecare valori diferite, dar apropiate ca valoare.\n' +
          '\n' +
          'Conform ipotezei De Broglie, atomii sunt suficient de mici încât încercarea de a le prezice comportamentul folosind fizica clasică — de exemplu, ca și cum ar fi niște bile de biliard — dă predicții vizibil incorecte din cauza efectelor cuantice. Prin dezvoltarea fizicii, modelele atomice au încorporat principii cuantice pentru a explica și prezice mai bine acest comportament.\n' +
          '\n' +
          'Fiecare atom este format dintr-un nucleu și din unul sau mai mulți electroni legați de nucleu. Nucleul este format din unul sau mai mulți protoni și, de obicei, dintr-un număr similar de neutroni. Protonii și neutronii se numesc nucleoni. Peste 99,94% din masa unui atom este concentrată în nucleu. Protonii au sarcină electrică pozitivă, electronii au sarcină electrică negativă, iar neutronii nu au sarcină electrică. Dacă numărul de protoni este egal cu cel de electroni, atunci atomul este neutru din punct de vedere electric. Dacă un atom are mai mulți sau mai puțini electroni decât protoni, atunci acesta are un o sarcină totală negativă, respectiv pozitivă, și se numește ion.\n' +
          '\n' +
          // tslint:disable-next-line:max-line-length
          'Electronii unui atom sunt atrași de protonii din nucleul atomic de această forță electromagnetică. Protonii și neutronii din nucleu sunt atrași unul de celălalt printr-o altă forță, forța nucleară, care de obicei este mai puternică decât forța electromagnetică de respingere ce acționează între protonii încărcați pozitiv. În anumite circumstanțe, forța electromagnetică de respingere poate deveni mai puternică decât forța nucleară, și nucleonii pot fi astfel scoși din nucleu, lăsând în urmă un element diferit: dezintegrarea nucleară rezultă în transmutație nucleară.',
        multimedia: './assets/pictures/800px-Helium_atom_QM.svg.png',
        createdOn: '21.10.2019'
      },
      {
        id: 7,
        title: 'Netflix',
        text: 'Netflix a fost fondată pe 29 august 1997, în Scotts Valley, California, de către Marc Randolph[11][12] și Reed Hastings. Randolph a lucrat ca director de marketing pentru Hastings companie, Pure Atria.[13] Randolph a fost un co-fondator al MicroWarehouse, o companie de compiuterind care se baza pe e-mail comande de companie, și mai târziu a fost angajat de Borland International ca vice-presedinte de marketing. Hastings, un om de stiinta de calculatore și matematician, a vândut Pure Atria la Rational Software Corporation în 1997, pentru 700 milioane dolari în ceea ce era pe atunci cea mai bogată achiziție în istoria Silicon Valley. Ei au venit cu ideea pentru Netflix în timp ce navetau între casele lor din Santa Cruz și sediul Pure Atria dinn Sunnyvale, deși Hasting a dat mai multe explicații pentru modul în care ideea a fost creată.[14]\n' +
          '\n' +
          'Hastings a investit 2,5 milioane de dolari în startup-ul  pentru Netflix.[15] Randolph admirat compania tânără de e-commerce Amazon și a vrut să găsească o mare categorie de elemente portabile de a le vinde prin Internet, utilizând un model similar. Ei au considerat și au respins casete VHS ca un element prea scump de stocare și prea delicat pentru transport. Când au auzit despre Dvd-uri, care a fost introdus pentru prima dată în Statele Unite ale americii pe 31 martie 1997,[16] au testat conceptul de vânzare sau închiriere de Dvd-uri prin e-mail, prin a da cu un e-mail un compact disc lui Hastings la casa lui din Santa Cruz. Atunci când discul a ajuns intact, ei au decis să se dea in idustria in valoare de $16 miliarde de home video de vânzări și închirieri. Hastings este de multe ori citat spunând că el a decis să înceapă Netflix după ce a fost amendat cu 40 de dolari de la un Blockbuster magazin pentru a fi târziu pentru a returna o copie a lui Apollo 13. Dar aceasta este o poveste model compusă de el și Randolph pentru a explica modelul de afaceri al companiei și motivația.\n' +
          '\n' +
          'Netflix a fost lansat pe 14 aprilie 1998, ca primul din lume portal on-line de închiriere de DVD-uri magazin,[17][18] cu doar 30 de angajați și 925 de titluri disponibile, care a fost aproape întregul catalog de Dvd-uri la timp,[19] prin pay-per-rent model cu prețurile și datele similare, care au fost luate de la rivalii lor, Blockbuster.',
        multimedia: './assets/pictures/1280px-Netflix_2015_logo.svg.png',
        createdOn: '15.12.2019'
      },
    ];
    // this.newsServiceService.getNews().subscribe(news => {
    //   this.news = news;
    // });
  }

  clickAdd() {
    this.showAddForm = true;
    this.showAddBtn = false;
  }

  deleteNewsItem(newsItem: NewsItem) {
    // Remove From UI
    this.news = this.news.filter(t => t.id !== newsItem.id);
  }

  addNewsItem(newsItem: NewsItem) {
    // tslint:disable-next-line:no-shadowed-variable
    this.news.push(newsItem);
  }

}
