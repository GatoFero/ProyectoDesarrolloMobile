package com.example.preguntasrapidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.preguntasrapidas.objetos.clases_padre.Pregunta;

import java.util.ArrayList;

public class TemaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tema);

        ImageButton backoneButton = findViewById(R.id.imbBackone);

        backoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TemaActivity.this, JuegosActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.juegoppt), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        crearPreguntasZoologico();
        crearPreguntasVideojuegos();
        crearPreguntasComponentes();
        crearPreguntasYoutubers();
        crearpreguntasCaricaturas();
        crearpreguntasAnime();
        crearpreguntasElectrodomesticos();
        crearpreguntasFrutas();
    }



    public ArrayList<ArrayList<Pregunta>> preguntasTotales = new ArrayList<>();
    public void iniciarPreguntas(View v){
        ImageButton botonTema = (ImageButton) v;
        String temaSeleccionado = botonTema.getContentDescription().toString();
        int buscarTema = Integer.parseInt(temaSeleccionado);
        Intent intent = new Intent(this, NivelActivity.class);

        ArrayList<Pregunta> preguntasPreparadas = preguntasTotales.get(buscarTema);
        Bundle bundle = new Bundle();
        bundle.putSerializable("prepararPreguntas", preguntasPreparadas);
        intent.putExtras(bundle);

        startActivity(intent);
    }
    public void crearPreguntasZoologico(){

        ArrayList<Pregunta> preguntasAnimales = new ArrayList<>();

        preguntasAnimales.add(new Pregunta("tortuga", "Lobo", "Tortuga", "Caballo", "Zebra", "Tortuga"));
        preguntasAnimales.add(new Pregunta("ardilla", "Camello", "Gorila", "Ardilla", "Tigre", "Ardilla"));
        preguntasAnimales.add(new Pregunta("mono", "Perro", "Mono", "Oso", "Tigre", "Mono"));
        preguntasAnimales.add(new Pregunta("lobo", "Huron", "Gorila", "Rinoceronte", "Lobo", "Lobo"));
        preguntasAnimales.add(new Pregunta("rinoceronte", "Rinoceronte", "Oso", "Ballena", "Bisonte", "Rinoceronte"));
        preguntasAnimales.add(new Pregunta("tigre", "Iguana", "Tigre", "Cebra", "Topo", "Tigre"));
        preguntasAnimales.add(new Pregunta("gorila", "Gorila", "Leon", "Topo", "Perro", "Gorila"));
        preguntasAnimales.add(new Pregunta("elefante", "Tapir", "Mono", "Elefante", "Caballo", "Elefante"));
        preguntasAnimales.add(new Pregunta("girafa", "Zorro", "Elefante", "Girafa", "Topo", "Girafa"));
        preguntasAnimales.add(new Pregunta("cocodrilo", "Iguana", "Cocodrilo", "Leon", "Tigre", "Cocodrilo"));
        preguntasAnimales.add(new Pregunta("huron", "Caballo", "Caballo", "Tigre", "Huron", "Huron"));
        preguntasAnimales.add(new Pregunta("tapir", "Tapir", "Oso", "Topo", "Toro", "Tapir"));
        preguntasAnimales.add(new Pregunta("camello", "Oveja", "Caballo", "Tigre", "Camello", "Camello"));
        preguntasAnimales.add(new Pregunta("iguana", "Oveja", "Huron", "Ardilla", "Iguana", "Iguana"));
        preguntasAnimales.add(new Pregunta("zorro", "Toro", "Zorro", "Lobo", "Perro", "Zorro"));
        preguntasAnimales.add(new Pregunta("toro", "Caballo", "Toro", "Vaca", "Bisonte", "Toro"));
        preguntasAnimales.add(new Pregunta("cerdo", "Tigre", "Oveja", "Tapir", "Cerdo", "Cerdo"));
        preguntasAnimales.add(new Pregunta("oveja", "Cocodrilo", "Oveja", "Toro", "Caballo","Oveja"));

        preguntasTotales.add(preguntasAnimales);
    }
    public void crearPreguntasVideojuegos(){

        ArrayList<Pregunta> preguntasVideoJuegos = new ArrayList<>();

        preguntasVideoJuegos.add(new Pregunta("link", "Pikachu", "Link", "Goku", "Spiderman", "Link"));
        preguntasVideoJuegos.add(new Pregunta("mario", "Bulma", "Luigi", "Waluigi", "Mario", "Mario"));
        preguntasVideoJuegos.add(new Pregunta("kirby", "Naruto", "Chun Li", "Kirby", "Spiderman", "Kirby"));
        preguntasVideoJuegos.add(new Pregunta("sonic", "Megaman", "Spiderman", "Sonic", "Crash", "Sonic"));
        preguntasVideoJuegos.add(new Pregunta("kratos", "Luigi", "Link", "Kratos", "Spiderman", "Kratos"));
        preguntasVideoJuegos.add(new Pregunta("bowser", "Megaman", "Link", "Sonic", "Bowser", "Bowser"));
        preguntasVideoJuegos.add(new Pregunta("bulma", "Warrio", "Yoshi", "Sonic", "Bulma", "Bulma"));
        preguntasVideoJuegos.add(new Pregunta("goku", "Kirby", "Metroid", "Goku", "Bulma", "Goku"));
        preguntasVideoJuegos.add(new Pregunta("pacman", "Megaman", "Kirby", "Metroid", "Pacman", "Pacman"));
        preguntasVideoJuegos.add(new Pregunta("pikachu", "Sonic", "Pikachu", "Megaman", "Pacman", "Pikachu"));
        preguntasVideoJuegos.add(new Pregunta("Crash", "Sonic", "Crash", "Megaman", "Pacman", "Crash"));
        preguntasVideoJuegos.add(new Pregunta("donkeykong", "Sonic", "Donkey Kong", "Megaman", "Pacman", "Donkey Kong"));
        preguntasVideoJuegos.add(new Pregunta("luigi", "Kirby", "Luigi", "Warrio", "Pacman", "Luigi"));
        preguntasVideoJuegos.add(new Pregunta("yoshi", "Yoshi", "Luigi", "Megaman", "Goku", "Yoshi"));
        preguntasVideoJuegos.add(new Pregunta("metroid", "Metroid", "Goku", "Bulma", "Kirby", "Metroid"));
        preguntasVideoJuegos.add(new Pregunta("leonvideo", "Metroid", "Leon", "Bulma", "Kirby", "Leon"));
        preguntasVideoJuegos.add(new Pregunta("spiderman", "Metroid", "Leon", "Bulma", "Spiderman", "Spiderman"));
        preguntasVideoJuegos.add(new Pregunta("chunli", "Bulma", "Chun li", "Kirby", "Spiderman", "Chun li"));
        preguntasVideoJuegos.add(new Pregunta("warrio", "Bulma", "Warrio", "Kirby", "Spiderman", "Warrio"));
        preguntasVideoJuegos.add(new Pregunta("megaman", "Bulma", "Warrio", "Kirby", "Megaman","Megaman"));

        preguntasTotales.add(preguntasVideoJuegos);
    }
    public void crearPreguntasComponentes(){

        ArrayList<Pregunta> preguntascomponentes = new ArrayList<>();
        preguntascomponentes.add(new Pregunta("memoriaram", "Audifonos", "Microfono", "Tarjeta Grafica", "Memoria Ram", "Memoria Ram"));
        preguntascomponentes.add(new Pregunta("procesador", "Camara Web", "Procesador", "Impresora", "Placa Madre", "Procesador"));
        preguntascomponentes.add(new Pregunta("discoduro", "Disco Duro", "Fuente de Poder", "Lector de discos", "Placa Madre", "Disco Duro"));
        preguntascomponentes.add(new Pregunta("ssd", "SSD", "Mouse", "Usb", "Tarjeta Grafica", "SSD"));
        preguntascomponentes.add(new Pregunta("enfriamientoliquido", "Fuente de Poder", "Camara Web", "Enfriamiento Liquido", "Tarjeta Grafica", "Enfriamiento Liquido"));
        preguntascomponentes.add(new Pregunta("ventiladores", "Monitor", "Teclado", "Microfono", "Audifonos", "Ventiladores"));
        preguntascomponentes.add(new Pregunta("tarjetagrafica", "Teclado", "Tarjeta Grafica", "Camara Web", "Ventiladores", "Tarjeta Grafica"));
        preguntascomponentes.add(new Pregunta("placamadre", "Teclado", "Procesador", "Tableta Digital", "Impresora", "Placa Madre"));
        preguntascomponentes.add(new Pregunta("mouse", "Disco Duro", "Procesador", "Mouse", "Placa Madre", "Mouse"));
        preguntascomponentes.add(new Pregunta("teclado", "Audifonos", "Microfono", "Teclado", "Memoria Ram", "Teclado"));
        preguntascomponentes.add(new Pregunta("monitor", "Teclado", "Tarjeta Grafica", "Camara Web", "Monitor", "Monitor"));
        preguntascomponentes.add(new Pregunta("fuentedepoder", "Monitor", "Fuente de Poder", "Microfono", "Audifonos", "Fuente de Poder"));
        preguntascomponentes.add(new Pregunta("gabinete", "Fuente de Poder", "Gabinete", "Enfriamiento Liquido", "Tarjeta Grafica", "Gabinete"));
        preguntascomponentes.add(new Pregunta("audifonos", "Disco Duro", "Procesador", "Audifonos", "Placa Madre", "Audifonos"));
        preguntascomponentes.add(new Pregunta("microfono", "Audifonos", "Usb", "Teclado", "Microfono", "Microfono"));
        preguntascomponentes.add(new Pregunta("camaraweb", "Teclado", "Procesador", "Camara Web", "Impresora", "Camara Web"));
        preguntascomponentes.add(new Pregunta("tabletadigital", "Disco Duro", "Tableta Digital", "Mouse", "Placa Madre", "Tableta Digital"));
        preguntascomponentes.add(new Pregunta("lectordediscos", "Disco Duro", "Procesador", "Lector de Discos", "Placa Madre", "Lector de Discos"));
        preguntascomponentes.add(new Pregunta("impresora", "Teclado", "Tarjeta Grafica", "Impresora", "Ventiladores","Impresora"));

        preguntasTotales.add(preguntascomponentes);
    }
    public void crearPreguntasYoutubers(){
        ArrayList<Pregunta> preguntasYoutubers = new ArrayList<>();

        preguntasYoutubers.add(new Pregunta("mrbeast", "AuronPlay", "JordiWild", "PewDiePie", "MrBeast", "MrBeast"));
        preguntasYoutubers.add(new Pregunta("auronplay", "AuronPlay", "WTFShow", "PewDiePie", "Vegetta777", "AuronPlay"));
        preguntasYoutubers.add(new Pregunta("germangarmendia", "AuronPlay", "JordiWild", "Andynsane", "German Garmendia", "German Garmendia"));
        preguntasYoutubers.add(new Pregunta("elrubius", "Fedelobo", "MikeCrack", "ElRubius", "Spreen", "ElRubius"));
        preguntasYoutubers.add(new Pregunta("fernanfloo", "FernanFloo", "TheDonato", "Fedelobo", "Vegetta777", "FernanFloo"));
        preguntasYoutubers.add(new Pregunta("ibai", "FernanFloo", "Ibai", "Fedelobo", "Vegetta777", "Ibai"));
        preguntasYoutubers.add(new Pregunta("luisitocomunica", "LuisitoComunica", "ElRubius", "PewDiePie", "Aroyitt", "LuisitoComunica"));
        preguntasYoutubers.add(new Pregunta("andynsane", "TheDaarick28", "Willirex", "Andynsane", "Aroyitt", "Andynsane"));
        preguntasYoutubers.add(new Pregunta("wtfshow", "EnchufeTV", "WTFShow", "Andynsane", "Cristinini", "WTFShow"));
        preguntasYoutubers.add(new Pregunta("jordiwild", "Andynsane", "JordiWild", "EnchufeTV", "MikeCrack", "JordiWild"));
        preguntasYoutubers.add(new Pregunta("vegetta777", "Willirex", "Vegetta777", "Fedelobo", "Andynsane", "Vegetta777"));
        preguntasYoutubers.add(new Pregunta("willirex", "ElRubius", "Willirex", "Vegetta777", "Andynsane", "Willirex"));
        preguntasYoutubers.add(new Pregunta("pewdiepie", "Vegetta777", "PewDiePie", "Andynsane", "Aroyitt", "PewDiePie"));
        preguntasYoutubers.add(new Pregunta("mikecrack", "ElRubius", "MikeCrack", "Vegetta777", "Andynsane", "MikeCrack"));
        preguntasYoutubers.add(new Pregunta("fedelobo", "Fernanfloo", "MikeCrack", "Fedelobo", "Willirex", "Fedelobo"));
        preguntasYoutubers.add(new Pregunta("thedonato", "TheDonato", "MikeCrack", "AuronPlay", "MrBeast", "TheDonato"));
        preguntasYoutubers.add(new Pregunta("enchufetv", "EnchufeTV", "ElRubius", "Fedelobo", "MrBeast", "EnchufeTV"));
        preguntasYoutubers.add(new Pregunta("spreen", "TheDaarick28", "Spreen", "Fedelobo", "MrBeast", "Spreen"));
        preguntasYoutubers.add(new Pregunta("thedaarick28", "Shadoune666", "Fedelobo", "TheDaarick28", "MrBeast", "TheDaarick28"));
        preguntasYoutubers.add(new Pregunta("arigameplays", "Cristinini", "Aroyitt", "AuronPlay", "ArigamePlays", "ArigamePlays"));
        preguntasYoutubers.add(new Pregunta("cristinini", "Cristinini", "ArigamePlays", "AuronPlay", "Aroyitt", "Cristinini"));
        preguntasYoutubers.add(new Pregunta("aroyitt", "AriGameplays", "Aroyitt", "Cristinini", "ArigamePlays","Aroyitt"));

        preguntasTotales.add(preguntasYoutubers);
    }
    public void crearpreguntasCaricaturas(){
        ArrayList<Pregunta> preguntasCaricaturas = new ArrayList<>();

	    preguntasCaricaturas.add(new Pregunta("ben10", "Naruto", "Bill y Mandy", "Ben10", "YuGiOh", "Ben10"));
        preguntasCaricaturas.add(new Pregunta("phineasyferb", "Phineas y Ferb", "Los cuatro fantasticos", "Jake y Finn", "Un Show Más", "Phineas y Ferb"));
        preguntasCaricaturas.add(new Pregunta("scoobydoo", "Popeye", "Scooby Doo", "El oso Yogui", "Snoopy", "Scooby Doo"));
        preguntasCaricaturas.add(new Pregunta("billymandy", "Billy Mandy", "Steven Universe", "La pantera rosa", "Los Picapiedras", "Billy Mandy"));
        preguntasCaricaturas.add(new Pregunta("loschicosdelbarrio", "Ben10", "Scooby Doo", "Thundercats", "Los chicos del barrio", "Los chicos del barrio"));
        preguntasCaricaturas.add(new Pregunta("lospitufos", "Los pitufos", "Los padrinos magicos", "Coraje el perro cobarde","Tom y Jerry","Los pitufos"));
        preguntasCaricaturas.add(new Pregunta("thundercats", "El oso Yogui", "Los Picapiedras", "Thundercats", "Steven Universe", "Thundercats"));
        preguntasCaricaturas.add(new Pregunta("corajeelperrocobarde", "Coraje el perro cobarde", "Steven Universe", "Ben10", "Billy Mandy", "Coraje el perro cobarde"));
        preguntasCaricaturas.add(new Pregunta("losjovenestitanes", "Scooby Doo", "Los jovenes titanes", "El oso Yogui", "Billy Mandy", "Los jovenes titanes"));
        preguntasCaricaturas.add(new Pregunta("yugioh", "Los pitufos", "Tom y Jerry", "Thundercats", "Yu Gi Oh", "Yu Gi Oh"));
        preguntasCaricaturas.add(new Pregunta("tomyjerry", "Scooby Doo", "El oso Yogui", "Tom y Jerry", "Billy Mandy", "Tom y Jerry"));
        preguntasCaricaturas.add(new Pregunta("johnnybravo", "Johnny Bravo", "Thundercats", "Steven Universe", "Ben10", "Johnny Bravo"));
        preguntasCaricaturas.add(new Pregunta("lospicapiedras", "Los pitufos", "El laboratorio de dexter", "Los Picapiedras", "Un show mas", "Los Picapiedras"));
        preguntasCaricaturas.add(new Pregunta("unshowmas", "Un show mas", "Thundercats", "Los padrinos magicos", "Billy Mandy", "Un show mas"));
        preguntasCaricaturas.add(new Pregunta("ellaboratoriodedexter", "Los jovenes titanes", "Thundercats", "Los pitufos", "El laboratorio de dexter", "El laboratorio de dexter"));
        preguntasCaricaturas.add(new Pregunta("jakeyfinn","Ben10", "Jake y Finn", "Droppy", "El cocodrilo Juancho", "Jake y Finn"));
        preguntasCaricaturas.add(new Pregunta("stevenuniverse", "Snoopy", "Steven Universe", "El oso Yogui", "Meteoro", "Steven Universe"));
        preguntasCaricaturas.add(new Pregunta("looneytunes", "Meteoro", "El oso Yogui", "Jake y Finn", "Looney tunes", "Looney tunes"));
        preguntasCaricaturas.add(new Pregunta("elescuadrondiabolico", "El escuadron diabolico", "Scooby Doo", "Johnny Bravo", "Thundercats", "El escuadron diabolico"));
        preguntasCaricaturas.add(new Pregunta("meteoro", "Steven Universe", "Los padrinos magicos", "Meteoro", "La pantera rosa", "Meteoro"));
        preguntasCaricaturas.add(new Pregunta("droppy", "Ben10", "Popeye", "La pantera rosa", "Droppy", "Droppy"));
        preguntasCaricaturas.add(new Pregunta("loscuatrofantasticos", "Los cuatro fantasticos", "Don gato y su pandilla", "La pantera rosa", "Snoopy", "Los cuatro fantasticos"));
        preguntasCaricaturas.add(new Pregunta("lapanterarosa", "Los padrinos magicos", "Jake y Finn", "Snoopy", "La pantera rosa", "La pantera rosa"));
        preguntasCaricaturas.add(new Pregunta("popeye", "Tom y Jerry", "Popeye", "La vaca y el pollito", "Johnny Bravo", "Popeye"));
        preguntasCaricaturas.add(new Pregunta("lospadrinosmagicos", "Los padrinos magicos", "Billy Mandy", "Los pitufos", "Ben10", "Los padrinos magicos"));
        preguntasCaricaturas.add(new Pregunta("snoopy", "Johnny Bravo", "La pantera rosa", "Yu Gi Oh", "Snoopy", "Snoopy"));
        preguntasCaricaturas.add(new Pregunta("dongatoysupandilla", "La vaca y el pollito", "Don gato y su pandilla", "Meteoro", "Thundercats", "Don gato y su pandilla"));
        preguntasCaricaturas.add(new Pregunta("elcocodrilojuancho", "Thundercats", "Tom y Jerry", "El cocodrilo Juancho", "Popeye", "El cocodrilo Juancho"));
        preguntasCaricaturas.add(new Pregunta("elosoyogui", "Tom y Jerry", "El oso Yogui", "Looney tunes", "Ben10", "El oso Yogui"));
        preguntasCaricaturas.add(new Pregunta("lavacayelpollito", "Steven Universe", "Jake y Finn", "La vaca y el pollito", "Los pitufos", "La vaca y el pollito"));

        preguntasTotales.add(preguntasCaricaturas);
}

public void crearpreguntasAnime(){
        ArrayList<Pregunta> preguntasAnime = new ArrayList<>();

        preguntasAnime.add(new Pregunta("bleach", "Naruto", "Bleach", "One Piece", "Fullmetal Alchemist", "Bleach"));
        preguntasAnime.add(new Pregunta("naruto", "Black Clover", "Naruto", "Demon Slayer", "Sword Art Online", "Naruto"));
        preguntasAnime.add(new Pregunta("onepiece", "Bleach", "One Piece", "Dragon Ball", "Naruto", "One Piece"));
        preguntasAnime.add(new Pregunta("dragonball", "Jojos Bizarre Adventure", "Dragon Ball", "One Piece", "Attack on Titan", "Dragon Ball"));
        preguntasAnime.add(new Pregunta("attackontitan", "Bleach", "Attack on Titan", "Demon Slayer", "One Piece", "Attack on Titan"));
        preguntasAnime.add(new Pregunta("deathnote", "Bleach", "Death Note", "One Piece", "Fairy Tail", "Death Note"));
        preguntasAnime.add(new Pregunta("onepunchman", "Fullmetal Alchemist", "One Punch Man", "naruto", "One Piece", "One Punch Man"));
        preguntasAnime.add(new Pregunta("myheroacademia", "Tokyo Ghoul", "My Hero Academia", "Black Clover", "One Piece", "My Hero Academia"));
        preguntasAnime.add(new Pregunta("fullmetalalchemist", "Black Clover", "Fullmetal Alchemist", "Tokyo Ghoul", "Sword Art Online", "Fullmetal Alchemist"));
        preguntasAnime.add(new Pregunta("swordartonline", "Demon Slayer", "Sword Art Online", "Fairy Tail", "Demon Slayer", "Sword Art Online"));
        preguntasAnime.add(new Pregunta("tokyoghoul", "My Hero Academia", "Tokyo Ghoul", "Death Note", "Naruto", "Tokyo Ghoul"));
        preguntasAnime.add(new Pregunta("hunterxhunter", "Demon Slayer", "Hunter x Hunter", "Death Parade", "Re:Zero", "Hunter x Hunter"));
        preguntasAnime.add(new Pregunta("blackclover", "Vinland Saga", "Black Clover", "Hunter x Hunter", "Demon Slayer", "Black Clover"));
        preguntasAnime.add(new Pregunta("demonslayer", "My Hero Academia", "Demon Slayer", "Dragon Ball", "Sword Art Online", "Demon Slayer"));
        preguntasAnime.add(new Pregunta("neongenesisevangelion", "Attack on Titan", "Neon Genesis Evangelion", "Jojos Bizarre Adventur", "Death Note", "Neon Genesis Evangelion"));
        preguntasAnime.add(new Pregunta("jojosbizarreadventure", "Attack on Titan", "Jojos Bizarre Adventure", "Re:Zero", "Death Note", "Jojos Bizarre Adventure"));
        preguntasAnime.add(new Pregunta("steinsgate", "Tokyo Ghoul", "SteinsGate", "Black Clover", "Sword Art Online", "SteinsGate"));
        preguntasAnime.add(new Pregunta("berserk", "Demon Slayer", "Berserk", "Eureka7", "No Game No Life", "Berserk"));
        preguntasAnime.add(new Pregunta("hellsing", "Spy x Family", "Hellsing", "Baccano", "One Piece", "Hellsing"));
        preguntasAnime.add(new Pregunta("baccano", "Beastars", "Baccano", "Eureka7", "Sword Art Online", "Baccano"));
        preguntasAnime.add(new Pregunta("eureka7", "Spy x Family", "Eureka7", "Hellsing", "Death Note", "Eureka7"));
        preguntasAnime.add(new Pregunta("nogamenolife", "Nisekoi", "No Game No Life", "Death Note", "Toradora", "No Game No Life"));
        preguntasAnime.add(new Pregunta("toradora", "Spy x Family", "Toradora", "Nisekoi", "Berserk", "Toradora"));
        preguntasAnime.add(new Pregunta("nisekoi", "Spy x Family", "Nisekoi", "Jujutsu Kaisen", "Hellsing", "Nisekoi"));
        preguntasAnime.add(new Pregunta("spyxfamily", "Attack on Titan", "Spy x Family", "Hellsing","ReZero","Spy x Family"));
        preguntasAnime.add(new Pregunta("beastars", "Jujutsu Kaisen", "Beastars", "Toradora", "Spy x Family", "Beastars"));
        preguntasAnime.add(new Pregunta("fairytail", "Neon Genesis Evangelion", "Fairy Tail", "Death Note", "One Piece", "Fairy Tail"));
        preguntasAnime.add(new Pregunta("jujutsukaisen", "Tokyo Ghoul", "Jujutsu Kaisen", "No Game No Life", "Beastars", "Jujutsu Kaisen"));
        preguntasAnime.add(new Pregunta("cowboybebop", "Death Note", "Cowboy Bebop", "Attack on Titan", "Re:Zero", "Cowboy Bebop"));

        preguntasTotales.add(preguntasAnime);

    }


    public void crearpreguntasElectrodomesticos(){
        ArrayList<Pregunta> preguntasElectrodomesticos = new ArrayList<>();


        preguntasElectrodomesticos.add(new Pregunta("microondas", "Frigider", "Microondas", "Arrocera", "Cafetera", "Microondas"));
        preguntasElectrodomesticos.add(new Pregunta("lavadora", "Cafetera", "Lavadora", "Secadora", "Lavavajillas", "Lavadora"));
        preguntasElectrodomesticos.add(new Pregunta("nevera", "Lavadora", "Nevera", "Congelador", "Dispensador de agua", "Nevera"));
        preguntasElectrodomesticos.add(new Pregunta("licuadora", "Frigider", "Licuadora", "Exprimidor", "Batidora", "Licuadora"));
        preguntasElectrodomesticos.add(new Pregunta("batidora", "Licuadora", "Batidora", "Frigider", "Exprimidor", "Batidora"));
        preguntasElectrodomesticos.add(new Pregunta("cafetera", "Microondas", "Cafetera", "Molinillo de cafe", "Tetera electrica", "Cafetera"));
        preguntasElectrodomesticos.add(new Pregunta("plancha", "Cafetera", "Plancha", "Centro de planchado", "Vaporizador", "Plancha"));
        preguntasElectrodomesticos.add(new Pregunta("horno", "Frigider", "Horno", "Horno microondas", "Horno tostador", "Horno"));
        preguntasElectrodomesticos.add(new Pregunta("secadora", "Secadora", "Frigider", "Lavadora", "Lavavajillas", "Secadora"));
        preguntasElectrodomesticos.add(new Pregunta("lavavajillas", "Lavadora", "Lavavajillas", "Frigider", "Secadora", "Lavavajillas"));
        preguntasElectrodomesticos.add(new Pregunta("aspiradora", "Freidora", "Aspiradora", "Robot aspirador", "Limpiador de vapor", "Aspiradora"));
        preguntasElectrodomesticos.add(new Pregunta("robotaspirador", "Frigider", "Robot aspirador", "Aspiradora", "Limpiador de vapor", "Robot aspirador"));
        preguntasElectrodomesticos.add(new Pregunta("freidora", "Rizador de pelo", "Freidora", "Tostadora", "Parrilla eléctrica", "Freidora"));
        preguntasElectrodomesticos.add(new Pregunta("exprimidor", "Cafetera", "Exprimidor", "Licuadora", "Batidora", "Exprimidor"));
        preguntasElectrodomesticos.add(new Pregunta("hornilla", "Hornilla", "Tostadora", "Estufa eléctrica", "Placa de inducción", "Hornilla"));
        preguntasElectrodomesticos.add(new Pregunta("tostadora", "Limpiador de vapor", "Tostadora", "Freidora", "Parrilla electrica", "Tostadora"));
        preguntasElectrodomesticos.add(new Pregunta("parrillaelectrica", "Olla arrocera", "Parrilla electrica", "Freidora", "Tostadora", "Parrilla electrica"));
        preguntasElectrodomesticos.add(new Pregunta("planchadepelo", "Tostadora", "Plancha de pelo", "Secador de pelo", "Rizador de pelo", "Plancha de pelo"));
        preguntasElectrodomesticos.add(new Pregunta("secadordepelo", "Freidora", "Secador de pelo", "Plancha de pelo", "Rizador de pelo", "Secador de pelo"));
        preguntasElectrodomesticos.add(new Pregunta("estufaelectrica", "Cafetera", "Estufa eléctrica", "Hornilla", "Placa de inducción", "Estufa electrica"));
        preguntasElectrodomesticos.add(new Pregunta("limpiadordevapor", "Frigider", "Limpiador de vapor", "Aspiradora", "Robot aspirador", "Limpiador de vapor"));
        preguntasElectrodomesticos.add(new Pregunta("placadeinduccion", "Licuadora", "Placa de inducción", "Hornilla", "Estufa electrica", "Placa de induccion"));
        preguntasElectrodomesticos.add(new Pregunta("batidorademano", "Picadora de carne", "Batidora de mano", "Licuadora", "Exprimidor", "Batidora de mano"));
        preguntasElectrodomesticos.add(new Pregunta("molinillodecafe", "Frigider", "Molinillo de cafe", "Cafetera", "Tetera eléctrica", "Molinillo de cafe"));
        preguntasElectrodomesticos.add(new Pregunta("máquinadepan", "Licuadora", "Máquina de pan", "Licuadora", "Frigider", "Máquina de pan"));
        preguntasElectrodomesticos.add(new Pregunta("teteraelectrica", "Frigider", "Tetera electrica", "Cafetera", "Molinillo de cafe", "Tetera electrica"));
        preguntasElectrodomesticos.add(new Pregunta("picadoradecarne", "Sandwichera", "Picadora de carne", "Licuadora", "Exprimidor", "Picadora de carne"));
        preguntasElectrodomesticos.add(new Pregunta("sandwichera", "Frigider", "Sandwichera", "Tostadora", "Freidora", "Sandwichera"));
        preguntasElectrodomesticos.add(new Pregunta("yogurtera", "Maquina de hielo", "Yogurtera", "Licuadora", "Maquina de pan", "Yogurtera"));
        preguntasElectrodomesticos.add(new Pregunta("maquinadehielo", "Yogurtera", "Maquina de hielo", "Licuadora", "Maquina de pan", "Maquina de hielo"));
        preguntasElectrodomesticos.add(new Pregunta("ollaarrocera", "Olla arrocera", "Frigider", "Licuadora", "Maquina de pan", "Olla arrocera"));

        preguntasTotales.add(preguntasElectrodomesticos);

    }

    public void crearpreguntasFrutas(){
        ArrayList<Pregunta> preguntasFrutas = new ArrayList<>();


        preguntasFrutas.add(new Pregunta("manzana", "Uva", "Manzana", "Banana", "Mango", "Manzana"));
        preguntasFrutas.add(new Pregunta("platano", "Pera", "Platano", "Mango", "Higo", "Platano"));
        preguntasFrutas.add(new Pregunta("naranja", "Platano", "Naranja", "Kiwi", "Maracuya", "Naranja"));
        preguntasFrutas.add(new Pregunta("uva", "Mandarina", "Uva", "Pera", "Manzana", "Uva"));
        preguntasFrutas.add(new Pregunta("pera", "Sandia", "Pera", "Sandia", "Pinia", "Pera"));
        preguntasFrutas.add(new Pregunta("sandia", "Fresa", "Sandia", "Higo", "Mango", "Sandia"));
        preguntasFrutas.add(new Pregunta("fresa", "Mango", "Fresa", "Frambuesa", "Ciruela", "Fresa"));
        preguntasFrutas.add(new Pregunta("kiwi", "Limon", "Kiwi", "Mango", "Granada", "Kiwi"));
        preguntasFrutas.add(new Pregunta("pinia", "Mango", "Pinia", "Mandarina", "Melon", "Pinia"));
        preguntasFrutas.add(new Pregunta("mango", "Ciruela", "Mango", "Nectarina", "Maracuya", "Mango"));
        preguntasFrutas.add(new Pregunta("ciruela", "Mandarina", "Ciruela", "Coco", "Platano", "Ciruela"));
        preguntasFrutas.add(new Pregunta("cereza", "Mango", "Cereza", "Kiwi", "Limon", "Cereza"));
        preguntasFrutas.add(new Pregunta("limon", "Mandarina", "Limon", "Manzana", "Ciruela", "Limon"));
        preguntasFrutas.add(new Pregunta("carambola", "Pinia", "Carambola", "Ciruela", "Sandia", "Carambola"));
        preguntasFrutas.add(new Pregunta("mandarina", "Naranja", "Mandarina", "Granada", "Melon", "Mandarina"));
        preguntasFrutas.add(new Pregunta("melocoton", "Papaya", "Melocoton", "Higo", "Mango", "Melocoton"));
        preguntasFrutas.add(new Pregunta("coco", "Limon", "Coco", "Melon", "Pinia", "Coco"));
        preguntasFrutas.add(new Pregunta("guayaba", "Fresa", "Guayaba", "Ciruela", "Higo", "Guayaba"));
        preguntasFrutas.add(new Pregunta("higo", "Tuna", "Higo", "Mamey", "Tamarindo", "Higo"));
        preguntasFrutas.add(new Pregunta("granada", "Durazno", "Granada", "Mandarina", "Frambuesa", "Granada"));
        preguntasFrutas.add(new Pregunta("frambuesa", "Higo", "Frambuesa", "Ciruela", "Pinia", "Frambuesa"));
        preguntasFrutas.add(new Pregunta("papaya", "Sandia", "Papaya", "Mango", "Kiwi", "Papaya"));
        preguntasFrutas.add(new Pregunta("chirimoya", "Higo", "Chirimoya", "Guayaba", "Mamey", "Chirimoya"));
        preguntasFrutas.add(new Pregunta("platano", "Durazno", "Platano", "Granada", "Higo", "Platano"));
        preguntasFrutas.add(new Pregunta("maracuya", "Ciruela", "Maracuya", "Durazno", "Limon", "Maracuya"));
        preguntasFrutas.add(new Pregunta("lima", "Melon", "Lima", "Papaya", "Kiwi", "Lima"));
        preguntasFrutas.add(new Pregunta("mora", "Mango", "Mora", "Fresa", "Ciruela", "Mora"));
        preguntasFrutas.add(new Pregunta("litchi", "Ciruela", "Litchi", "Maracuya", "Durazno", "Litchi"));
        preguntasFrutas.add(new Pregunta("durazno", "Uva", "Durazno", "Pera", "Limon", "Durazno"));
        preguntasFrutas.add(new Pregunta("nispero", "Maracuya", "Nispero", "Higo", "Pinia", "Nispero"));


        preguntasTotales.add(preguntasFrutas);
    }

}