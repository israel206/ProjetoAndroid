package com.israelhack.projetoacspsf.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.israelhack.projetoacspsf.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    // atributos das cardView
    private CardView cadIndCard,cadDomCard,visitDomCard;

    private FirebaseAuth usuarioFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // definição das cardView
        cadIndCard = (CardView) findViewById(R.id.cad_Ind);
        cadDomCard = (CardView) findViewById(R.id.cad_domic);
        visitDomCard = (CardView) findViewById(R.id.visit_Domic);

        //adicionando ouvintes de click na cardView
        cadIndCard.setOnClickListener(this);
        cadDomCard.setOnClickListener(this);
        visitDomCard.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        //intenção
        Intent i;
        switch (v.getId()){
            case R.id.cad_Ind : i = new Intent(MainActivity.this,CadastroIndividualFireB.class);startActivity(i);break;
            case R.id.cad_domic : i = new Intent(MainActivity.this,CadastroDomiciliarFireB.class);startActivity(i); break;
            case R.id.visit_Domic : i = new Intent(MainActivity.this,VisitaDomiciliarFireB.class); startActivity(i);break;
            default:break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Action_Sair) {
            deslogarUsuario();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this,HistoricoGeral.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(MainActivity.this,"Testando Do Menu Lateral",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(MainActivity.this,"Testando Do Menu Lateral",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_manage) {
            Toast.makeText(MainActivity.this,"Testando Do Menu Lateral",Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(MainActivity.this,"Testando Do Menu Lateral",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(MainActivity.this,"Testando Do Menu Lateral",Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //Metodos do Action botão
    private void deslogarUsuario() {
        usuarioFirebase.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
