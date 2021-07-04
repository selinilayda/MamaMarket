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
            "Kuzu Etli Yavru Köpek Maması 15 Kg",
            "Dana Etli Yetişkin Köpek Maması",
            "Biftekli Yetişkin Köpek Maması ",
            "Kitten Kedi Kuru Maması",
            "Kuzu Etli Yetişkin Kedi Maması 15 Kg",
            "Somonlu Kısırlaştırılmış Kedi Maması 10 kg",
            "Discus Ve Ciklet Balık Yemi Kova",
            "Vipan Balık Pul Yem",
            "Kaplumbağa Yemi Turtle Sticks Green 1000ml",
            "Gammarus Turtle Kaplumbağa Yemi 1000 Ml ",
            "Yerli Standart Tavşan Yemi Karışık 2 Kg",
            "Nature Plan Premium Tavşan Yemi 800gr 5paket",
            "Poşet Muhabbet Kuşu Yemi 1 Kg",
            "Paraket Sultan Cennet Papağanı Yemi 1kg "
        )
        val urun_fiyat = arrayOf("14.99", "12.99", "39.99", "45.99", "39.99", "24.99", "39.99", "19.99", "14.99", "9.99", "39.99", "19.99", "20.99", "45.99", "69.99")
        val urun_aciklama = arrayOf(
            "Köpeğinizin parlak tüylere sahip olmasına destek olur. Sağlıklı bir kalbe sahip olmasını sağlar.",
            "Analiz Değerleri Ham Protein : %28 Ham Yağ : %16 Ham Sellüloz : %3,5 İnorganik Madde : %8 Vitamin A : 18000 IU/kg Vitamin D : 1500 IU/kg Vitamin E : 150 mg/kg Vitamin C : 200 mg/kg",
            "15 Kg Aroma : Biftekli Üretim Yeri : Yerli",
            "Sindirim sağlığını korur. -Bağışıklık sistemi sağlığını destekler",
            "Sağlıklı gelişimi destekler.",
            "Kısırlaştırma sonrası hassaslaşan ve yeme eğilimi artan genç ya da yetişkin kısırlaştırılmış kedilerde kilo alımının ve taş oluşumunun önlenmesini sağlar",
            "Discus balığı için ideal yemdir.",
            "Tüm Akvaryum balıklar için en ideal yemlerden biridir.",
            "Bol tanelidir.",
            "Küçük ve toz parçalıdır.",
            "Karışık tavşan yemidir.",
            "Gerçek havuç taneleri ve kekik ile lezzetlendirilmiştir",
            "Ham maddeler: sarı darı, beyaz darı,aspur,nijer,keten,iç yulaf,vitaminli galete parçacıklarından oluşmaktadır.",
            "Paraket cinsi küçük ırk kuşlar için özel olarak formüle edilmiştir"
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