package mx.edu.ittepic.ladm_u1_practica1_disenomenuprincipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import mx.edu.ittepic.ladm_u1_practica1_disenomenuprincipal.databinding.ActivityMainBinding
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var instalado:String
        //Inicio de que se ha instalado
        instalado=""

        binding.alertimg.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alerta test")
                .setMessage("Esta es una alerta")
                .setNeutralButton("Gracias"){d,i->
                    d.dismiss()
                }
                .setNegativeButton("Salir"){d,i->
                    d.cancel()
                }
                .show()
        }//click alertimg
        binding.toastimg.setOnClickListener{
            Toast.makeText(this,"Esto es un text",Toast.LENGTH_LONG).show()
        }//click toastimg

        binding.actimg.setOnClickListener {
            var ventanaTest = Intent(this,MainActivity2::class.java)
            startActivity(ventanaTest)
        }//click actimg

        binding.firefox.setOnClickListener {
            var ventanaFF = Intent(this,ActFirefox::class.java)
            startActivity(ventanaFF)
            if(!instalado.contains("Se instaló Firefox\n")){ instalado = instalado + "Se instaló Firefox\n"}//if
        }//firefox
        binding.edge.setOnClickListener {
            var ventanaEdge = Intent(this,ActEdge::class.java)
            startActivity(ventanaEdge)
            if(!instalado.contains("Se instaló Edge\n")){ instalado = instalado + "Se instaló Edge\n"}//if
        }//edge
        binding.chrome.setOnClickListener {
            var ventanaChrome = Intent(this,ActChrome::class.java)
            startActivity(ventanaChrome)
            if(!instalado.contains("Se instaló Chrome\n")){ instalado = instalado + "Se instaló Chrome\n"}//if
        }//chrome
        binding.playstore.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Google Playstore")
                .setMessage("No se tiene internet, intente luego")
                .setNegativeButton("Cancelar"){d,i->
                    d.cancel()
                }
                .setPositiveButton("Aceptar"){d,i->
                    d.dismiss()
                }
                .show()
        }//plays

        binding.Angularinst.setOnClickListener {
            var mensaje = "Se instaló Angular\n"
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
            if(!instalado.contains(mensaje)){
                instalado = instalado + mensaje
            }//if
        }//angular
        binding.Vueinst.setOnClickListener {
            var mensaje = "Se instaló Vue\n"
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
            if(!instalado.contains(mensaje)){
                instalado = instalado + mensaje
            }//if
        }//angular
        binding.Reactinst.setOnClickListener {
            var mensaje = "Se instaló React\n"
            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
            if(!instalado.contains(mensaje)){
                instalado = instalado + mensaje
            }//if
        }//angular


        binding.crearArchivo.setOnClickListener {
            crearArchivo(instalado)
        }//crearArchivo


    }//onCreate

    fun crearArchivo(mensaje:String){
        try {
            var archivo = OutputStreamWriter(openFileOutput("instalaciones.txt", MODE_PRIVATE))
            archivo.write(mensaje)
            archivo.flush()
            archivo.close()
            Toast.makeText(this,"Se guardaron las instalaciones",Toast.LENGTH_LONG).show()
        }catch (e:Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }

}//MainActivity