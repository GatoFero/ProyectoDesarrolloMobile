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

import com.example.preguntasrapidas.objetos.clases_padre.Question;

import java.util.ArrayList;

public class TemaActivity extends AppCompatActivity {

    private final ArrayList<Question> questionsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tema);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.categoryLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void setQuestions(View v){
        ImageButton categorySelect = (ImageButton) v;
        int category = (Integer.parseInt(categorySelect.getContentDescription().toString()));
        setQuestionSelect(category);

        Intent intent = new Intent(this, LevelQuestionsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("questionsSelect", questionsList);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void setQuestionSelect(int category){
        switch (category){
            case 1:
               setQuestionsZoo(questionsList);
               break;
            case 2:
                setQuestionsVideoGames(questionsList);
                break;
            case 3:
                setQuestionsTechnology(questionsList);
                break;
            case 4:
                setQuestionsInfluencer(questionsList);
                break;
            case 5:
                setQuestionCartoons(questionsList);
                break;
            case 6:
                setQuestionAnime(questionsList);
                break;
            case 7:
                setQuestionsAppliances(questionsList);
                break;
            case 8:
                setQuestionsFruits(questionsList);
                break;
        }
    }
    public void setQuestionsZoo(ArrayList<Question> questionList){
        questionList.add(new Question("tortuga", "Lobo", "Tortuga", "Caballo", "Zebra", "Tortuga"));
        questionList.add(new Question("ardilla", "Camello", "Gorila", "Ardilla", "Tigre", "Ardilla"));
        questionList.add(new Question("mono", "Perro", "Mono", "Oso", "Tigre", "Mono"));
        questionList.add(new Question("lobo", "Huron", "Gorila", "Rinoceronte", "Lobo", "Lobo"));
        questionList.add(new Question("rinoceronte", "Rinoceronte", "Oso", "Ballena", "Bisonte", "Rinoceronte"));
        questionList.add(new Question("tigre", "Iguana", "Tigre", "Cebra", "Topo", "Tigre"));
        questionList.add(new Question("gorila", "Gorila", "Leon", "Topo", "Perro", "Gorila"));
        questionList.add(new Question("elefante", "Tapir", "Mono", "Elefante", "Caballo", "Elefante"));
        questionList.add(new Question("girafa", "Zorro", "Elefante", "Girafa", "Topo", "Girafa"));
        questionList.add(new Question("cocodrilo", "Iguana", "Cocodrilo", "Leon", "Tigre", "Cocodrilo"));
        questionList.add(new Question("huron", "Caballo", "Caballo", "Tigre", "Huron", "Huron"));
        questionList.add(new Question("tapir", "Tapir", "Oso", "Topo", "Toro", "Tapir"));
        questionList.add(new Question("camello", "Oveja", "Caballo", "Tigre", "Camello", "Camello"));
        questionList.add(new Question("iguana", "Oveja", "Huron", "Ardilla", "Iguana", "Iguana"));
        questionList.add(new Question("zorro", "Toro", "Zorro", "Lobo", "Perro", "Zorro"));
        questionList.add(new Question("toro", "Caballo", "Toro", "Vaca", "Bisonte", "Toro"));
        questionList.add(new Question("cerdo", "Tigre", "Oveja", "Tapir", "Cerdo", "Cerdo"));
        questionList.add(new Question("oveja", "Cocodrilo", "Oveja", "Toro", "Caballo","Oveja"));
    }
    public void setQuestionsVideoGames(ArrayList<Question> questionList){
        questionList.add(new Question("link", "Pikachu", "Link", "Goku", "Spiderman", "Link"));
        questionList.add(new Question("mario", "Bulma", "Luigi", "Waluigi", "Mario", "Mario"));
        questionList.add(new Question("kirby", "Naruto", "Chun Li", "Kirby", "Spiderman", "Kirby"));
        questionList.add(new Question("sonic", "Megaman", "Spiderman", "Sonic", "Crash", "Sonic"));
        questionList.add(new Question("kratos", "Luigi", "Link", "Kratos", "Spiderman", "Kratos"));
        questionList.add(new Question("bowser", "Megaman", "Link", "Sonic", "Bowser", "Bowser"));
        questionList.add(new Question("bulma", "Warrio", "Yoshi", "Sonic", "Bulma", "Bulma"));
        questionList.add(new Question("goku", "Kirby", "Metroid", "Goku", "Bulma", "Goku"));
        questionList.add(new Question("pacman", "Megaman", "Kirby", "Metroid", "Pacman", "Pacman"));
        questionList.add(new Question("pikachu", "Sonic", "Pikachu", "Megaman", "Pacman", "Pikachu"));
        questionList.add(new Question("Crash", "Sonic", "Crash", "Megaman", "Pacman", "Crash"));
        questionList.add(new Question("donkeykong", "Sonic", "Donkey Kong", "Megaman", "Pacman", "Donkey Kong"));
        questionList.add(new Question("luigi", "Kirby", "Luigi", "Warrio", "Pacman", "Luigi"));
        questionList.add(new Question("yoshi", "Yoshi", "Luigi", "Megaman", "Goku", "Yoshi"));
        questionList.add(new Question("metroid", "Metroid", "Goku", "Bulma", "Kirby", "Metroid"));
        questionList.add(new Question("leonvideo", "Metroid", "Leon", "Bulma", "Kirby", "Leon"));
        questionList.add(new Question("spiderman", "Metroid", "Leon", "Bulma", "Spiderman", "Spiderman"));
        questionList.add(new Question("chunli", "Bulma", "Chun li", "Kirby", "Spiderman", "Chun li"));
        questionList.add(new Question("warrio", "Bulma", "Warrio", "Kirby", "Spiderman", "Warrio"));
        questionList.add(new Question("megaman", "Bulma", "Warrio", "Kirby", "Megaman","Megaman"));
    }
    public void setQuestionsTechnology(ArrayList<Question> questionList){
        questionList.add(new Question("memoriaram", "Audifonos", "Microfono", "Tarjeta Grafica", "Memoria Ram", "Memoria Ram"));
        questionList.add(new Question("procesador", "Camara Web", "Procesador", "Impresora", "Placa Madre", "Procesador"));
        questionList.add(new Question("discoduro", "Disco Duro", "Fuente de Poder", "Lector de discos", "Placa Madre", "Disco Duro"));
        questionList.add(new Question("ssd", "SSD", "Mouse", "Usb", "Tarjeta Grafica", "SSD"));
        questionList.add(new Question("enfriamientoliquido", "Fuente de Poder", "Camara Web", "Enfriamiento Liquido", "Tarjeta Grafica", "Enfriamiento Liquido"));
        questionList.add(new Question("ventiladores", "Monitor", "Teclado", "Microfono", "Audifonos", "Ventiladores"));
        questionList.add(new Question("tarjetagrafica", "Teclado", "Tarjeta Grafica", "Camara Web", "Ventiladores", "Tarjeta Grafica"));
        questionList.add(new Question("placamadre", "Teclado", "Procesador", "Tableta Digital", "Impresora", "Placa Madre"));
        questionList.add(new Question("mouse", "Disco Duro", "Procesador", "Mouse", "Placa Madre", "Mouse"));
        questionList.add(new Question("teclado", "Audifonos", "Microfono", "Teclado", "Memoria Ram", "Teclado"));
        questionList.add(new Question("monitor", "Teclado", "Tarjeta Grafica", "Camara Web", "Monitor", "Monitor"));
        questionList.add(new Question("fuentedepoder", "Monitor", "Fuente de Poder", "Microfono", "Audifonos", "Fuente de Poder"));
        questionList.add(new Question("gabinete", "Fuente de Poder", "Gabinete", "Enfriamiento Liquido", "Tarjeta Grafica", "Gabinete"));
        questionList.add(new Question("audifonos", "Disco Duro", "Procesador", "Audifonos", "Placa Madre", "Audifonos"));
        questionList.add(new Question("microfono", "Audifonos", "Usb", "Teclado", "Microfono", "Microfono"));
        questionList.add(new Question("camaraweb", "Teclado", "Procesador", "Camara Web", "Impresora", "Camara Web"));
        questionList.add(new Question("tabletadigital", "Disco Duro", "Tableta Digital", "Mouse", "Placa Madre", "Tableta Digital"));
        questionList.add(new Question("lectordediscos", "Disco Duro", "Procesador", "Lector de Discos", "Placa Madre", "Lector de Discos"));
        questionList.add(new Question("impresora", "Teclado", "Tarjeta Grafica", "Impresora", "Ventiladores","Impresora"));
    }
    public void setQuestionsInfluencer(ArrayList<Question> questionList){
        questionList.add(new Question("mrbeast", "AuronPlay", "JordiWild", "PewDiePie", "MrBeast", "MrBeast"));
        questionList.add(new Question("auronplay", "AuronPlay", "WTFShow", "PewDiePie", "Vegetta777", "AuronPlay"));
        questionList.add(new Question("germangarmendia", "AuronPlay", "JordiWild", "Andynsane", "German Garmendia", "German Garmendia"));
        questionList.add(new Question("elrubius", "Fedelobo", "MikeCrack", "ElRubius", "Spreen", "ElRubius"));
        questionList.add(new Question("fernanfloo", "FernanFloo", "TheDonato", "Fedelobo", "Vegetta777", "FernanFloo"));
        questionList.add(new Question("ibai", "FernanFloo", "Ibai", "Fedelobo", "Vegetta777", "Ibai"));
        questionList.add(new Question("luisitocomunica", "LuisitoComunica", "ElRubius", "PewDiePie", "Aroyitt", "LuisitoComunica"));
        questionList.add(new Question("andynsane", "TheDaarick28", "Willirex", "Andynsane", "Aroyitt", "Andynsane"));
        questionList.add(new Question("wtfshow", "EnchufeTV", "WTFShow", "Andynsane", "Cristinini", "WTFShow"));
        questionList.add(new Question("jordiwild", "Andynsane", "JordiWild", "EnchufeTV", "MikeCrack", "JordiWild"));
        questionList.add(new Question("vegetta777", "Willirex", "Vegetta777", "Fedelobo", "Andynsane", "Vegetta777"));
        questionList.add(new Question("willirex", "ElRubius", "Willirex", "Vegetta777", "Andynsane", "Willirex"));
        questionList.add(new Question("pewdiepie", "Vegetta777", "PewDiePie", "Andynsane", "Aroyitt", "PewDiePie"));
        questionList.add(new Question("mikecrack", "ElRubius", "MikeCrack", "Vegetta777", "Andynsane", "MikeCrack"));
        questionList.add(new Question("fedelobo", "Fernanfloo", "MikeCrack", "Fedelobo", "Willirex", "Fedelobo"));
        questionList.add(new Question("thedonato", "TheDonato", "MikeCrack", "AuronPlay", "MrBeast", "TheDonato"));
        questionList.add(new Question("enchufetv", "EnchufeTV", "ElRubius", "Fedelobo", "MrBeast", "EnchufeTV"));
        questionList.add(new Question("spreen", "TheDaarick28", "Spreen", "Fedelobo", "MrBeast", "Spreen"));
        questionList.add(new Question("thedaarick28", "Shadoune666", "Fedelobo", "TheDaarick28", "MrBeast", "TheDaarick28"));
        questionList.add(new Question("arigameplays", "Cristinini", "Aroyitt", "AuronPlay", "ArigamePlays", "ArigamePlays"));
        questionList.add(new Question("cristinini", "Cristinini", "ArigamePlays", "AuronPlay", "Aroyitt", "Cristinini"));
        questionList.add(new Question("aroyitt", "AriGameplays", "Aroyitt", "Cristinini", "ArigamePlays","Aroyitt"));
    }
    public void setQuestionCartoons(ArrayList<Question> questionList){
	    questionList.add(new Question("ben10", "Naruto", "Bill y Mandy", "Ben10", "YuGiOh", "Ben10"));
        questionList.add(new Question("phineasyferb", "Phineas y Ferb", "Los cuatro fantasticos", "Jake y Finn", "Un Show Más", "Phineas y Ferb"));
        questionList.add(new Question("scoobydoo", "Popeye", "Scooby Doo", "El oso Yogui", "Snoopy", "Scooby Doo"));
        questionList.add(new Question("billymandy", "Billy Mandy", "Steven Universe", "La pantera rosa", "Los Picapiedras", "Billy Mandy"));
        questionList.add(new Question("loschicosdelbarrio", "Ben10", "Scooby Doo", "Thundercats", "Los chicos del barrio", "Los chicos del barrio"));
        questionList.add(new Question("lospitufos", "Los pitufos", "Los padrinos magicos", "Coraje el perro cobarde","Tom y Jerry","Los pitufos"));
        questionList.add(new Question("thundercats", "El oso Yogui", "Los Picapiedras", "Thundercats", "Steven Universe", "Thundercats"));
        questionList.add(new Question("corajeelperrocobarde", "Coraje el perro cobarde", "Steven Universe", "Ben10", "Billy Mandy", "Coraje el perro cobarde"));
        questionList.add(new Question("losjovenestitanes", "Scooby Doo", "Los jovenes titanes", "El oso Yogui", "Billy Mandy", "Los jovenes titanes"));
        questionList.add(new Question("yugioh", "Los pitufos", "Tom y Jerry", "Thundercats", "Yu Gi Oh", "Yu Gi Oh"));
        questionList.add(new Question("tomyjerry", "Scooby Doo", "El oso Yogui", "Tom y Jerry", "Billy Mandy", "Tom y Jerry"));
        questionList.add(new Question("johnnybravo", "Johnny Bravo", "Thundercats", "Steven Universe", "Ben10", "Johnny Bravo"));
        questionList.add(new Question("lospicapiedras", "Los pitufos", "El laboratorio de dexter", "Los Picapiedras", "Un show mas", "Los Picapiedras"));
        questionList.add(new Question("unshowmas", "Un show mas", "Thundercats", "Los padrinos magicos", "Billy Mandy", "Un show mas"));
        questionList.add(new Question("ellaboratoriodedexter", "Los jovenes titanes", "Thundercats", "Los pitufos", "El laboratorio de dexter", "El laboratorio de dexter"));
        questionList.add(new Question("jakeyfinn","Ben10", "Jake y Finn", "Droppy", "El cocodrilo Juancho", "Jake y Finn"));
        questionList.add(new Question("stevenuniverse", "Snoopy", "Steven Universe", "El oso Yogui", "Meteoro", "Steven Universe"));
        questionList.add(new Question("looneytunes", "Meteoro", "El oso Yogui", "Jake y Finn", "Looney tunes", "Looney tunes"));
        questionList.add(new Question("elescuadrondiabolico", "El escuadron diabolico", "Scooby Doo", "Johnny Bravo", "Thundercats", "El escuadron diabolico"));
        questionList.add(new Question("meteoro", "Steven Universe", "Los padrinos magicos", "Meteoro", "La pantera rosa", "Meteoro"));
        questionList.add(new Question("droppy", "Ben10", "Popeye", "La pantera rosa", "Droppy", "Droppy"));
        questionList.add(new Question("loscuatrofantasticos", "Los cuatro fantasticos", "Don gato y su pandilla", "La pantera rosa", "Snoopy", "Los cuatro fantasticos"));
        questionList.add(new Question("lapanterarosa", "Los padrinos magicos", "Jake y Finn", "Snoopy", "La pantera rosa", "La pantera rosa"));
        questionList.add(new Question("popeye", "Tom y Jerry", "Popeye", "La vaca y el pollito", "Johnny Bravo", "Popeye"));
        questionList.add(new Question("lospadrinosmagicos", "Los padrinos magicos", "Billy Mandy", "Los pitufos", "Ben10", "Los padrinos magicos"));
        questionList.add(new Question("snoopy", "Johnny Bravo", "La pantera rosa", "Yu Gi Oh", "Snoopy", "Snoopy"));
        questionList.add(new Question("dongatoysupandilla", "La vaca y el pollito", "Don gato y su pandilla", "Meteoro", "Thundercats", "Don gato y su pandilla"));
        questionList.add(new Question("elcocodrilojuancho", "Thundercats", "Tom y Jerry", "El cocodrilo Juancho", "Popeye", "El cocodrilo Juancho"));
        questionList.add(new Question("elosoyogui", "Tom y Jerry", "El oso Yogui", "Looney tunes", "Ben10", "El oso Yogui"));
        questionList.add(new Question("lavacayelpollito", "Steven Universe", "Jake y Finn", "La vaca y el pollito", "Los pitufos", "La vaca y el pollito"));
}
public void setQuestionAnime(ArrayList<Question> questionList){
        questionList.add(new Question("bleach", "Naruto", "Bleach", "One Piece", "Fullmetal Alchemist", "Bleach"));
        questionList.add(new Question("naruto", "Black Clover", "Naruto", "Demon Slayer", "Sword Art Online", "Naruto"));
        questionList.add(new Question("onepiece", "Bleach", "One Piece", "Dragon Ball", "Naruto", "One Piece"));
        questionList.add(new Question("dragonball", "Jojos Bizarre Adventure", "Dragon Ball", "One Piece", "Attack on Titan", "Dragon Ball"));
        questionList.add(new Question("attackontitan", "Bleach", "Attack on Titan", "Demon Slayer", "One Piece", "Attack on Titan"));
        questionList.add(new Question("deathnote", "Bleach", "Death Note", "One Piece", "Fairy Tail", "Death Note"));
        questionList.add(new Question("onepunchman", "Fullmetal Alchemist", "One Punch Man", "naruto", "One Piece", "One Punch Man"));
        questionList.add(new Question("myheroacademia", "Tokyo Ghoul", "My Hero Academia", "Black Clover", "One Piece", "My Hero Academia"));
        questionList.add(new Question("fullmetalalchemist", "Black Clover", "Fullmetal Alchemist", "Tokyo Ghoul", "Sword Art Online", "Fullmetal Alchemist"));
        questionList.add(new Question("swordartonline", "Demon Slayer", "Sword Art Online", "Fairy Tail", "Demon Slayer", "Sword Art Online"));
        questionList.add(new Question("tokyoghoul", "My Hero Academia", "Tokyo Ghoul", "Death Note", "Naruto", "Tokyo Ghoul"));
        questionList.add(new Question("hunterxhunter", "Demon Slayer", "Hunter x Hunter", "Death Parade", "Re:Zero", "Hunter x Hunter"));
        questionList.add(new Question("blackclover", "Vinland Saga", "Black Clover", "Hunter x Hunter", "Demon Slayer", "Black Clover"));
        questionList.add(new Question("demonslayer", "My Hero Academia", "Demon Slayer", "Dragon Ball", "Sword Art Online", "Demon Slayer"));
        questionList.add(new Question("neongenesisevangelion", "Attack on Titan", "Neon Genesis Evangelion", "Jojos Bizarre Adventur", "Death Note", "Neon Genesis Evangelion"));
        questionList.add(new Question("jojosbizarreadventure", "Attack on Titan", "Jojos Bizarre Adventure", "Re:Zero", "Death Note", "Jojos Bizarre Adventure"));
        questionList.add(new Question("steinsgate", "Tokyo Ghoul", "SteinsGate", "Black Clover", "Sword Art Online", "SteinsGate"));
        questionList.add(new Question("berserk", "Demon Slayer", "Berserk", "Eureka7", "No Game No Life", "Berserk"));
        questionList.add(new Question("hellsing", "Spy x Family", "Hellsing", "Baccano", "One Piece", "Hellsing"));
        questionList.add(new Question("baccano", "Beastars", "Baccano", "Eureka7", "Sword Art Online", "Baccano"));
        questionList.add(new Question("eureka7", "Spy x Family", "Eureka7", "Hellsing", "Death Note", "Eureka7"));
        questionList.add(new Question("nogamenolife", "Nisekoi", "No Game No Life", "Death Note", "Toradora", "No Game No Life"));
        questionList.add(new Question("toradora", "Spy x Family", "Toradora", "Nisekoi", "Berserk", "Toradora"));
        questionList.add(new Question("nisekoi", "Spy x Family", "Nisekoi", "Jujutsu Kaisen", "Hellsing", "Nisekoi"));
        questionList.add(new Question("spyxfamily", "Attack on Titan", "Spy x Family", "Hellsing","ReZero","Spy x Family"));
        questionList.add(new Question("beastars", "Jujutsu Kaisen", "Beastars", "Toradora", "Spy x Family", "Beastars"));
        questionList.add(new Question("fairytail", "Neon Genesis Evangelion", "Fairy Tail", "Death Note", "One Piece", "Fairy Tail"));
        questionList.add(new Question("jujutsukaisen", "Tokyo Ghoul", "Jujutsu Kaisen", "No Game No Life", "Beastars", "Jujutsu Kaisen"));
        questionList.add(new Question("cowboybebop", "Death Note", "Cowboy Bebop", "Attack on Titan", "Re:Zero", "Cowboy Bebop"));
    }


    public void setQuestionsAppliances(ArrayList<Question> questionList){
        questionList.add(new Question("microondas", "Frigider", "Microondas", "Arrocera", "Cafetera", "Microondas"));
        questionList.add(new Question("lavadora", "Cafetera", "Lavadora", "Secadora", "Lavavajillas", "Lavadora"));
        questionList.add(new Question("nevera", "Lavadora", "Nevera", "Congelador", "Dispensador de agua", "Nevera"));
        questionList.add(new Question("licuadora", "Frigider", "Licuadora", "Exprimidor", "Batidora", "Licuadora"));
        questionList.add(new Question("batidora", "Licuadora", "Batidora", "Frigider", "Exprimidor", "Batidora"));
        questionList.add(new Question("cafetera", "Microondas", "Cafetera", "Molinillo de cafe", "Tetera electrica", "Cafetera"));
        questionList.add(new Question("plancha", "Cafetera", "Plancha", "Centro de planchado", "Vaporizador", "Plancha"));
        questionList.add(new Question("horno", "Frigider", "Horno", "Horno microondas", "Horno tostador", "Horno"));
        questionList.add(new Question("secadora", "Secadora", "Frigider", "Lavadora", "Lavavajillas", "Secadora"));
        questionList.add(new Question("lavavajillas", "Lavadora", "Lavavajillas", "Frigider", "Secadora", "Lavavajillas"));
        questionList.add(new Question("aspiradora", "Freidora", "Aspiradora", "Robot aspirador", "Limpiador de vapor", "Aspiradora"));
        questionList.add(new Question("robotaspirador", "Frigider", "Robot aspirador", "Aspiradora", "Limpiador de vapor", "Robot aspirador"));
        questionList.add(new Question("freidora", "Rizador de pelo", "Freidora", "Tostadora", "Parrilla eléctrica", "Freidora"));
        questionList.add(new Question("exprimidor", "Cafetera", "Exprimidor", "Licuadora", "Batidora", "Exprimidor"));
        questionList.add(new Question("hornilla", "Hornilla", "Tostadora", "Estufa eléctrica", "Placa de inducción", "Hornilla"));
        questionList.add(new Question("tostadora", "Limpiador de vapor", "Tostadora", "Freidora", "Parrilla electrica", "Tostadora"));
        questionList.add(new Question("parrillaelectrica", "Olla arrocera", "Parrilla electrica", "Freidora", "Tostadora", "Parrilla electrica"));
        questionList.add(new Question("planchadepelo", "Tostadora", "Plancha de pelo", "Secador de pelo", "Rizador de pelo", "Plancha de pelo"));
        questionList.add(new Question("secadordepelo", "Freidora", "Secador de pelo", "Plancha de pelo", "Rizador de pelo", "Secador de pelo"));
        questionList.add(new Question("estufaelectrica", "Cafetera", "Estufa eléctrica", "Hornilla", "Placa de inducción", "Estufa electrica"));
        questionList.add(new Question("limpiadordevapor", "Frigider", "Limpiador de vapor", "Aspiradora", "Robot aspirador", "Limpiador de vapor"));
        questionList.add(new Question("placadeinduccion", "Licuadora", "Placa de inducción", "Hornilla", "Estufa electrica", "Placa de induccion"));
        questionList.add(new Question("batidorademano", "Picadora de carne", "Batidora de mano", "Licuadora", "Exprimidor", "Batidora de mano"));
        questionList.add(new Question("molinillodecafe", "Frigider", "Molinillo de cafe", "Cafetera", "Tetera eléctrica", "Molinillo de cafe"));
        questionList.add(new Question("máquinadepan", "Licuadora", "Máquina de pan", "Licuadora", "Frigider", "Máquina de pan"));
        questionList.add(new Question("teteraelectrica", "Frigider", "Tetera electrica", "Cafetera", "Molinillo de cafe", "Tetera electrica"));
        questionList.add(new Question("picadoradecarne", "Sandwichera", "Picadora de carne", "Licuadora", "Exprimidor", "Picadora de carne"));
        questionList.add(new Question("sandwichera", "Frigider", "Sandwichera", "Tostadora", "Freidora", "Sandwichera"));
        questionList.add(new Question("yogurtera", "Maquina de hielo", "Yogurtera", "Licuadora", "Maquina de pan", "Yogurtera"));
        questionList.add(new Question("maquinadehielo", "Yogurtera", "Maquina de hielo", "Licuadora", "Maquina de pan", "Maquina de hielo"));
        questionList.add(new Question("ollaarrocera", "Olla arrocera", "Frigider", "Licuadora", "Maquina de pan", "Olla arrocera"));
    }

    public void setQuestionsFruits(ArrayList<Question> questionList){
        questionList.add(new Question("manzana", "Uva", "Manzana", "Banana", "Mango", "Manzana"));
        questionList.add(new Question("platano", "Pera", "Platano", "Mango", "Higo", "Platano"));
        questionList.add(new Question("naranja", "Platano", "Naranja", "Kiwi", "Maracuya", "Naranja"));
        questionList.add(new Question("uva", "Mandarina", "Uva", "Pera", "Manzana", "Uva"));
        questionList.add(new Question("pera", "Sandia", "Pera", "Sandia", "Pinia", "Pera"));
        questionList.add(new Question("sandia", "Fresa", "Sandia", "Higo", "Mango", "Sandia"));
        questionList.add(new Question("fresa", "Mango", "Fresa", "Frambuesa", "Ciruela", "Fresa"));
        questionList.add(new Question("kiwi", "Limon", "Kiwi", "Mango", "Granada", "Kiwi"));
        questionList.add(new Question("pinia", "Mango", "Pinia", "Mandarina", "Melon", "Pinia"));
        questionList.add(new Question("mango", "Ciruela", "Mango", "Nectarina", "Maracuya", "Mango"));
        questionList.add(new Question("ciruela", "Mandarina", "Ciruela", "Coco", "Platano", "Ciruela"));
        questionList.add(new Question("cereza", "Mango", "Cereza", "Kiwi", "Limon", "Cereza"));
        questionList.add(new Question("limon", "Mandarina", "Limon", "Manzana", "Ciruela", "Limon"));
        questionList.add(new Question("carambola", "Pinia", "Carambola", "Ciruela", "Sandia", "Carambola"));
        questionList.add(new Question("mandarina", "Naranja", "Mandarina", "Granada", "Melon", "Mandarina"));
        questionList.add(new Question("melocoton", "Papaya", "Melocoton", "Higo", "Mango", "Melocoton"));
        questionList.add(new Question("coco", "Limon", "Coco", "Melon", "Pinia", "Coco"));
        questionList.add(new Question("guayaba", "Fresa", "Guayaba", "Ciruela", "Higo", "Guayaba"));
        questionList.add(new Question("higo", "Tuna", "Higo", "Mamey", "Tamarindo", "Higo"));
        questionList.add(new Question("granada", "Durazno", "Granada", "Mandarina", "Frambuesa", "Granada"));
        questionList.add(new Question("frambuesa", "Higo", "Frambuesa", "Ciruela", "Pinia", "Frambuesa"));
        questionList.add(new Question("papaya", "Sandia", "Papaya", "Mango", "Kiwi", "Papaya"));
        questionList.add(new Question("chirimoya", "Higo", "Chirimoya", "Guayaba", "Mamey", "Chirimoya"));
        questionList.add(new Question("platano", "Durazno", "Platano", "Granada", "Higo", "Platano"));
        questionList.add(new Question("maracuya", "Ciruela", "Maracuya", "Durazno", "Limon", "Maracuya"));
        questionList.add(new Question("lima", "Melon", "Lima", "Papaya", "Kiwi", "Lima"));
        questionList.add(new Question("mora", "Mango", "Mora", "Fresa", "Ciruela", "Mora"));
        questionList.add(new Question("litchi", "Ciruela", "Litchi", "Maracuya", "Durazno", "Litchi"));
        questionList.add(new Question("durazno", "Uva", "Durazno", "Pera", "Limon", "Durazno"));
        questionList.add(new Question("nispero", "Maracuya", "Nispero", "Higo", "Pinia", "Nispero"));
    }

}