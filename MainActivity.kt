package com.nicolaspanteleev.tpintegrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.nicolaspanteleev.tpintegrador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //para actualizar textView antes de que se apriete compareButton por 1ª vez
        mainViewModel.updateComparador(binding.editText1.text.toString(),binding.editText2.text.toString())

        mainViewModel.comparador.observe(this){
            if (binding.editText1.text.toString()==""||binding.editText2.text.toString()=="")
                binding.textView.text="¡Completa ambos textos para comparar!"
            else if (it.compare())
                binding.textView.text="Las cadenas de texto son IGUALES"
            else
                binding.textView.text="Las cadenas de texto son DISTINTAS"
        }

        binding.compareButton.setOnClickListener{
            mainViewModel.updateComparador(binding.editText1.text.toString(),binding.editText2.text.toString())
        }
    }
}