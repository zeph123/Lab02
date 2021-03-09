package pollub.ism.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
// importy widoków
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // deklaracja uchwytów widoków
    private TextView poleTekstowe = null;
    private EditText poleEdycyjne = null;
    private Button przycisk1 = null,
            przycisk2 = null,
            przycisk3 = null;
    // liczniki wywołań metod cyklu życia
    private int licznikCreate = 0,
            licznikStart = 0,
            licznikResume = 0,
            licznikPause = 0,
            licznikStop = 0,
            licznikRestart = 0,
            licznikDestroy = 0;

    private static String KEY_CREATE = "Wartosc licznika create",
            KEY_START = "Wartosc licznika start",
            KEY_RESUME = "Wartosc licznika resume",
            KEY_PAUSE = "Wartosc licznika pause",
            KEY_STOP = "Wartosc licznika stop",
            KEY_RESTART = "Wartosc licznika restart",
            KEY_DESTROY = "Wartosc licznika destroy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // podłączenie uchwytów do widoków
        poleTekstowe = (TextView) findViewById(R.id.textView2);
        poleEdycyjne = (EditText) findViewById(R.id.editText);
        przycisk1 = (Button) findViewById(R.id.button1);
        przycisk2 = (Button) findViewById(R.id.button2);
        przycisk3 = (Button) findViewById(R.id.button3);
        // zablokowanie możliwości edycji w polu edycyjnym
        poleEdycyjne.setEnabled(false);
        // zmiana napisu na przycisku przy wykorzystaniu zasobów
        przycisk2.setText(getResources().getString(R.string.odblokuj));
        // metody cyklu życia
        powiedzCoWykonujesz("onCreate");
        // inkrementacja licznika
        licznikCreate++;
    }

    // szkielety metod cyklu życia
    @Override
    protected void onStart() {
        super.onStart();
        // metody cyklu życia
        powiedzCoWykonujesz("onStart");
        // inkrementacja licznika
        licznikStart++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // metody cyklu życia
        powiedzCoWykonujesz("onResume");
        // inkrementacja licznika
        licznikResume++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        // metody cyklu życia
        powiedzCoWykonujesz("onPause");
        // inkrementacja licznika
        licznikPause++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        // metody cyklu życia
        powiedzCoWykonujesz("onStop");
        // inkrementacja licznika
        licznikStop++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // metody cyklu życia
        powiedzCoWykonujesz("onRestart");
        // inkrementacja licznika
        licznikRestart++;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // metody cyklu życia
        powiedzCoWykonujesz("onDestroy");
        // inkrementacja licznika
        licznikDestroy++;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CREATE, licznikCreate);
        outState.putInt(KEY_START, licznikStart);
        outState.putInt(KEY_RESUME, licznikResume);
        outState.putInt(KEY_PAUSE, licznikPause);
        outState.putInt(KEY_STOP, licznikStop);
        outState.putInt(KEY_RESTART, licznikRestart);
        outState.putInt(KEY_DESTROY, licznikDestroy);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        licznikCreate = savedInstanceState.getInt(KEY_CREATE, 0);
        licznikStart = savedInstanceState.getInt(KEY_START, 0);
        licznikResume = savedInstanceState.getInt(KEY_RESUME, 0);
        licznikPause = savedInstanceState.getInt(KEY_PAUSE, 0);
        licznikStop = savedInstanceState.getInt(KEY_STOP, 0);
        licznikRestart = savedInstanceState.getInt(KEY_RESTART, 0);
        licznikDestroy = savedInstanceState.getInt(KEY_DESTROY, 0);

    }

    // metoda modyfikująca napisy w widokach textView2 oraz editText
    private void powiedzCoWykonujesz(String info) {
        poleTekstowe.setText(info);
        poleEdycyjne.append(info + "\n");
    }
    // metoda służąca do usuwania tekstu z widoku editText
    public void wyczyscPoleEdycyjne(android.view.View view) {
        poleEdycyjne.setText("");
    }
    // metoda odblokowującą/zablokowującą możliwość edycji w editText
    public void zablokujOdblokujPoleEdycyjne(android.view.View view) {
        poleEdycyjne.setEnabled(!poleEdycyjne.isEnabled());
        if (poleEdycyjne.isEnabled()) {
            przycisk2.setText(getResources().getString(R.string.zablokuj));
        } else {
            przycisk2.setText(getResources().getString(R.string.odblokuj));
        }
    }
    // metoda wypisująca zmienne w widoku editText
    public void wyswietlZmienne(android.view.View view) {
        String info = "create=" + licznikCreate
                + " start=" + licznikStart
                + " resume=" + licznikResume
                + "\npause=" + licznikPause
                + " stop=" + licznikStop
                + " restart=" + licznikRestart
                + "\ndestroy=" + licznikDestroy;

        poleEdycyjne.append(info+"\n");
    }

}