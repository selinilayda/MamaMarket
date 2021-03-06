package com.example.mamamarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.MutableLiveData
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mamamarket.entity.Product
import com.example.mamamarket.repo.ProductsDaoRepository
import com.example.mamamarket.repo.UsersDaoRepository
import com.example.mamamarket.retrofit.ApiUtils
import com.example.mamamarket.retrofit.ProductsDaoInterface
import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var pdaoi: ProductsDaoInterface
    val sepet_array = arrayListOf<Product>()
    var urunlerListesi = MutableLiveData<List<Product>>()
    private lateinit var pdaor: ProductsDaoRepository
    lateinit var udaor: UsersDaoRepository



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)


        pdaoi = ApiUtils.getProductsDaoInterface()
        pdaor = ProductsDaoRepository()
        pdaor.tumUrunleriAl()


        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        //  NavigationUI.setupWithNavController(bottomNav, navHostFragment.navController)

        val navView: BottomNavigationView = bottomNav

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.anasayfaFragment3, R.id.kampanyalarFragment2,
                R.id.sepetFragment3, R.id.kisiDetayFragment
            )
        )

        navView.setupWithNavController(navController)

        //  dongu()

        //   getArray()
    }


    //   fun getArray(): ArrayList<Product> = sepet_array


    fun dongu() {
        val urun_adi = arrayOf(
            "Kuzu Etli Yavru K??pek Mamas?? 15 Kg",
            "Dana Etli Yeti??kin K??pek Mamas??",
            "Biftekli Yeti??kin K??pek Mamas?? ",
            "Kitten Kedi Kuru Mamas??",
            "Kuzu Etli Yeti??kin Kedi Mamas?? 15 Kg",
            "Somonlu K??s??rla??t??r??lm???? Kedi Mamas?? 10 kg",
            "Discus Ve Ciklet Bal??k Yemi Kova",
            "Vipan Bal??k Pul Yem",
            "Kaplumba??a Yemi Turtle Sticks Green 1000ml",
            "Gammarus Turtle Kaplumba??a Yemi 1000 Ml ",
            "Yerli Standart Tav??an Yemi Kar??????k 2 Kg",
            "Nature Plan Premium Tav??an Yemi 800gr 5paket",
            "Po??et Muhabbet Ku??u Yemi 1 Kg",
            "Paraket Sultan Cennet Papa??an?? Yemi 1kg "
        )
        val urun_fiyat = arrayOf("14.99", "12.99", "39.99", "45.99", "39.99", "24.99", "39.99", "19.99", "14.99", "9.99", "39.99", "19.99", "20.99", "45.99", "69.99")
        val urun_aciklama = arrayOf(
            "K??pe??inizin parlak t??ylere sahip olmas??na destek olur. Sa??l??kl?? bir kalbe sahip olmas??n?? sa??lar.",
            "Analiz De??erleri Ham Protein : %28 Ham Ya?? : %16 Ham Sell??loz : %3,5 ??norganik Madde : %8 Vitamin A : 18000 IU/kg Vitamin D : 1500 IU/kg Vitamin E : 150 mg/kg Vitamin C : 200 mg/kg",
            "15 Kg Aroma : Biftekli ??retim Yeri : Yerli",
            "Sindirim sa??l??????n?? korur. -Ba????????kl??k sistemi sa??l??????n?? destekler",
            "Sa??l??kl?? geli??imi destekler.",
            "K??s??rla??t??rma sonras?? hassasla??an ve yeme e??ilimi artan gen?? ya da yeti??kin k??s??rla??t??r??lm???? kedilerde kilo al??m??n??n ve ta?? olu??umunun ??nlenmesini sa??lar",
            "Discus bal?????? i??in ideal yemdir.",
            "T??m Akvaryum bal??klar i??in en ideal yemlerden biridir.",
            "Bol tanelidir.",
            "K??????k ve toz par??al??d??r.",
            "Kar??????k tav??an yemidir.",
            "Ger??ek havu?? taneleri ve kekik ile lezzetlendirilmi??tir",
            "Ham maddeler: sar?? dar??, beyaz dar??,aspur,nijer,keten,i?? yulaf,vitaminli galete par??ac??klar??ndan olu??maktad??r.",
            "Paraket cinsi k??????k ??rk ku??lar i??in ??zel olarak form??le edilmi??tir"
        )
        val urun_gorsel_url = arrayOf(
            "https://i.hizliresim.com/3drmpy2.jpeg",
            "https://i.hizliresim.com/7pkxkca.jpeg",
            "https://i.hizliresim.com/s6s7qck.jpeg",
            "https://i.hizliresim.com/kl2924h.jpeg",
            "https://i.hizliresim.com/ah0mdrj.jpeg",
            "https://i.hizliresim.com/7pk96ey.jpeg",
            "https://i.hizliresim.com/ovxx4n5.jpeg",
            "https://i.hizliresim.com/3z90x8h.jpeg",
            "https://i.hizliresim.com/8vt8tvl.jpeg",
            "https://i.hizliresim.com/k74pzwp.jpeg",
            "https://i.hizliresim.com/1pqkljj.jpeg",
            "https://i.hizliresim.com/fwah247.jpeg",
            "https://i.hizliresim.com/c6pt0uu.jpeg",
            "https://i.hizliresim.com/tr0i9ja.jpeg",
            "https://i.hizliresim.com/6jlhkuk.jpeg"
        )

        for (k in 0..urun_adi.size - 1) {
            pdaor.urunlerEkle(satici_adi = "selinilaydakarabulut", urun_adi[k], urun_fiyat[k], urun_aciklama[k], urun_gorsel_url[k])
        }

    }


}