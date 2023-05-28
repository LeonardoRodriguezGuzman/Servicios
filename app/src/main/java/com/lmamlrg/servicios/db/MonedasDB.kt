package com.lmamlrg.servicios.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = arrayOf(Moneda::class,Cambio::class), version = 1)
abstract class MonedasDB : RoomDatabase() {
    abstract fun monedaDAO() : MonedaDAO
    abstract fun cambioDAO() : CambioDAO

    private class MonedasDBCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){

        override fun onCreate(db : SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { database ->
                scope.launch (Dispatchers.IO){
                    var monedaDAO = database.monedaDAO()

                    // Delete all content here.
                    monedaDAO.deleteAll()

                    // Add sample words.
                    //val modenada1 = Moneda(0,"","", "")

                    monedaDAO.insertar(Moneda(0,"AED","UAE Dirham","United Arab Emirates"))
                    monedaDAO.insertar(Moneda(0,"AFN","Afghan Afghani","Afghanistan"))
                    monedaDAO.insertar(Moneda(0,"ALL","Albanian Lek","Albania"))
                    monedaDAO.insertar(Moneda(0,"AMD","Armenian Dram","Armenia"))
                    monedaDAO.insertar(Moneda(0,"ANG","Netherlands Antillian Guilder","Netherlands Antilles"))
                    monedaDAO.insertar(Moneda(0,"AOA","Angolan Kwanza","Angola"))
                    monedaDAO.insertar(Moneda(0,"ARS","Argentine Peso","Argentina"))
                    monedaDAO.insertar(Moneda(0,"AUD","Australian Dollar","Australia"))
                    monedaDAO.insertar(Moneda(0,"AWG","Aruban Florin","Aruba"))
                    monedaDAO.insertar(Moneda(0,"AZN","Azerbaijani Manat","Azerbaijan"))
                    monedaDAO.insertar(Moneda(0,"BAM","Bosnia and Herzegovina Mark","Bosnia and Herzegovina"))
                    monedaDAO.insertar(Moneda(0,"BBD","Barbados Dollar","Barbados"))
                    monedaDAO.insertar(Moneda(0,"BDT","Bangladeshi Taka","Bangladesh"))
                    monedaDAO.insertar(Moneda(0,"BGN","Bulgarian Lev","Bulgaria"))
                    monedaDAO.insertar(Moneda(0,"BHD","Bahraini Dinar","Bahrain"))
                    monedaDAO.insertar(Moneda(0,"BIF","Burundian Franc","Burundi"))
                    monedaDAO.insertar(Moneda(0,"BMD","Bermudian Dollar","Bermuda"))
                    monedaDAO.insertar(Moneda(0,"BND","Brunei Dollar","Brunei"))
                    monedaDAO.insertar(Moneda(0,"BOB","Bolivian Boliviano","Bolivia"))
                    monedaDAO.insertar(Moneda(0,"BRL","Brazilian Real","Brazil"))
                    monedaDAO.insertar(Moneda(0,"BSD","Bahamian Dollar","Bahamas"))
                    monedaDAO.insertar(Moneda(0,"BTN","Bhutanese Ngultrum","Bhutan"))
                    monedaDAO.insertar(Moneda(0,"BWP","Botswana Pula","Botswana"))
                    monedaDAO.insertar(Moneda(0,"BYN","Belarusian Ruble","Belarus"))
                    monedaDAO.insertar(Moneda(0,"BZD","Belize Dollar","Belize"))
                    monedaDAO.insertar(Moneda(0,"CAD","Canadian Dollar","Canada"))
                    monedaDAO.insertar(Moneda(0,"CDF","Congolese Franc","Democratic Republic of the Congo"))
                    monedaDAO.insertar(Moneda(0,"CHF","Swiss Franc","Switzerland"))
                    monedaDAO.insertar(Moneda(0,"CLP","Chilean Peso","Chile"))
                    monedaDAO.insertar(Moneda(0,"CNY","Chinese Renminbi","China"))
                    monedaDAO.insertar(Moneda(0,"COP","Colombian Peso","Colombia"))
                    monedaDAO.insertar(Moneda(0,"CRC","Costa Rican Colon","Costa Rica"))
                    monedaDAO.insertar(Moneda(0,"CUP","Cuban Peso","Cuba"))
                    monedaDAO.insertar(Moneda(0,"CVE","Cape Verdean Escudo","Cape Verde"))
                    monedaDAO.insertar(Moneda(0,"CZK","Czech Koruna","Czech Republic"))
                    monedaDAO.insertar(Moneda(0,"DJF","Djiboutian Franc","Djibouti"))
                    monedaDAO.insertar(Moneda(0,"DKK","Danish Krone","Denmark"))
                    monedaDAO.insertar(Moneda(0,"DOP","Dominican Peso","Dominican Republic"))
                    monedaDAO.insertar(Moneda(0,"DZD","Algerian Dinar","Algeria"))
                    monedaDAO.insertar(Moneda(0,"EGP","Egyptian Pound","Egypt"))
                    monedaDAO.insertar(Moneda(0,"ERN","Eritrean Nakfa","Eritrea"))
                    monedaDAO.insertar(Moneda(0,"ETB","Ethiopian Birr","Ethiopia"))
                    monedaDAO.insertar(Moneda(0,"EUR","Euro","European Union"))
                    monedaDAO.insertar(Moneda(0,"FJD","Fiji Dollar","Fiji"))
                    monedaDAO.insertar(Moneda(0,"FKP","Falkland Islands Pound","Falkland Islands"))
                    monedaDAO.insertar(Moneda(0,"FOK","Faroese Króna","Faroe Islands"))
                    monedaDAO.insertar(Moneda(0,"GBP","Pound Sterling","United Kingdom"))
                    monedaDAO.insertar(Moneda(0,"GEL","Georgian Lari","Georgia"))
                    monedaDAO.insertar(Moneda(0,"GGP","Guernsey Pound","Guernsey"))
                    monedaDAO.insertar(Moneda(0,"GHS","Ghanaian Cedi","Ghana"))
                    monedaDAO.insertar(Moneda(0,"GIP","Gibraltar Pound","Gibraltar"))
                    monedaDAO.insertar(Moneda(0,"GMD","Gambian Dalasi","The Gambia"))
                    monedaDAO.insertar(Moneda(0,"GNF","Guinean Franc","Guinea"))
                    monedaDAO.insertar(Moneda(0,"GTQ","Guatemalan Quetzal","Guatemala"))
                    monedaDAO.insertar(Moneda(0,"GYD","Guyanese Dollar","Guyana"))
                    monedaDAO.insertar(Moneda(0,"HKD","Hong Kong Dollar","Hong Kong"))
                    monedaDAO.insertar(Moneda(0,"HNL","Honduran Lempira","Honduras"))
                    monedaDAO.insertar(Moneda(0,"HRK","Croatian Kuna","Croatia"))
                    monedaDAO.insertar(Moneda(0,"HTG","Haitian Gourde","Haiti"))
                    monedaDAO.insertar(Moneda(0,"HUF","Hungarian Forint","Hungary"))
                    monedaDAO.insertar(Moneda(0,"IDR","Indonesian Rupiah","Indonesia"))
                    monedaDAO.insertar(Moneda(0,"ILS","Israeli New Shekel","Israel"))
                    monedaDAO.insertar(Moneda(0,"IMP","Manx Pound","Isle of Man"))
                    monedaDAO.insertar(Moneda(0,"INR","Indian Rupee","India"))
                    monedaDAO.insertar(Moneda(0,"IQD","Iraqi Dinar","Iraq"))
                    monedaDAO.insertar(Moneda(0,"IRR","Iranian Rial","Iran"))
                    monedaDAO.insertar(Moneda(0,"ISK","Icelandic Króna","Iceland"))
                    monedaDAO.insertar(Moneda(0,"JEP","Jersey Pound","Jersey"))
                    monedaDAO.insertar(Moneda(0,"JMD","Jamaican Dollar","Jamaica"))
                    monedaDAO.insertar(Moneda(0,"JOD","Jordanian Dinar","Jordan"))
                    monedaDAO.insertar(Moneda(0,"JPY","Japanese Yen","Japan"))
                    monedaDAO.insertar(Moneda(0,"KES","Kenyan Shilling","Kenya"))
                    monedaDAO.insertar(Moneda(0,"KGS","Kyrgyzstani Som","Kyrgyzstan"))
                    monedaDAO.insertar(Moneda(0,"KHR","Cambodian Riel","Cambodia"))
                    monedaDAO.insertar(Moneda(0,"KID","Kiribati Dollar","Kiribati"))
                    monedaDAO.insertar(Moneda(0,"KMF","Comorian Franc","Comoros"))
                    monedaDAO.insertar(Moneda(0,"KRW","South Korean Won","South Korea"))
                    monedaDAO.insertar(Moneda(0,"KWD","Kuwaiti Dinar","Kuwait"))
                    monedaDAO.insertar(Moneda(0,"KYD","Cayman Islands Dollar","Cayman Islands"))
                    monedaDAO.insertar(Moneda(0,"KZT","Kazakhstani Tenge","Kazakhstan"))
                    monedaDAO.insertar(Moneda(0,"LAK","Lao Kip","Laos"))
                    monedaDAO.insertar(Moneda(0,"LBP","Lebanese Pound","Lebanon"))
                    monedaDAO.insertar(Moneda(0,"LKR","Sri Lanka Rupee","Sri Lanka"))
                    monedaDAO.insertar(Moneda(0,"LRD","Liberian Dollar","Liberia"))
                    monedaDAO.insertar(Moneda(0,"LSL","Lesotho Loti","Lesotho"))
                    monedaDAO.insertar(Moneda(0,"LYD","Libyan Dinar","Libya"))
                    monedaDAO.insertar(Moneda(0,"MAD","Moroccan Dirham","Morocco"))
                    monedaDAO.insertar(Moneda(0,"MDL","Moldovan Leu","Moldova"))
                    monedaDAO.insertar(Moneda(0,"MGA","Malagasy Ariary","Madagascar"))
                    monedaDAO.insertar(Moneda(0,"MKD","Macedonian Denar","North Macedonia"))
                    monedaDAO.insertar(Moneda(0,"MMK","Burmese Kyat","Myanmar"))
                    monedaDAO.insertar(Moneda(0,"MNT","Mongolian Tögrög","Mongolia"))
                    monedaDAO.insertar(Moneda(0,"MOP","Macanese Pataca","Macau"))
                    monedaDAO.insertar(Moneda(0,"MRU","Mauritanian Ouguiya","Mauritania"))
                    monedaDAO.insertar(Moneda(0,"MUR","Mauritian Rupee","Mauritius"))
                    monedaDAO.insertar(Moneda(0,"MVR","Maldivian Rufiyaa","Maldives"))
                    monedaDAO.insertar(Moneda(0,"MWK","Malawian Kwacha","Malawi"))
                    monedaDAO.insertar(Moneda(0,"MXN","Mexican Peso","Mexico"))
                    monedaDAO.insertar(Moneda(0,"MYR","Malaysian Ringgit","Malaysia"))
                    monedaDAO.insertar(Moneda(0,"MZN","Mozambican Metical","Mozambique"))
                    monedaDAO.insertar(Moneda(0,"NAD","Namibian Dollar","Namibia"))
                    monedaDAO.insertar(Moneda(0,"NGN","Nigerian Naira","Nigeria"))
                    monedaDAO.insertar(Moneda(0,"NIO","Nicaraguan Córdoba","Nicaragua"))
                    monedaDAO.insertar(Moneda(0,"NOK","Norwegian Krone","Norway"))
                    monedaDAO.insertar(Moneda(0,"NPR","Nepalese Rupee","Nepal"))
                    monedaDAO.insertar(Moneda(0,"NZD","New Zealand Dollar","New Zealand"))
                    monedaDAO.insertar(Moneda(0,"OMR","Omani Rial","Oman"))
                    monedaDAO.insertar(Moneda(0,"PAB","Panamanian Balboa","Panama"))
                    monedaDAO.insertar(Moneda(0,"PEN","Peruvian Sol","Peru"))
                    monedaDAO.insertar(Moneda(0,"PGK","Papua New Guinean Kina","Papua New Guinea"))
                    monedaDAO.insertar(Moneda(0,"PHP","Philippine Peso","Philippines"))
                    monedaDAO.insertar(Moneda(0,"PKR","Pakistani Rupee","Pakistan"))
                    monedaDAO.insertar(Moneda(0,"PLN","Polish Złoty","Poland"))
                    monedaDAO.insertar(Moneda(0,"PYG","Paraguayan Guaraní","Paraguay"))
                    monedaDAO.insertar(Moneda(0,"QAR","Qatari Riyal","Qatar"))
                    monedaDAO.insertar(Moneda(0,"RON","Romanian Leu","Romania"))
                    monedaDAO.insertar(Moneda(0,"RSD","Serbian Dinar","Serbia"))
                    monedaDAO.insertar(Moneda(0,"RUB","Russian Ruble","Russia"))
                    monedaDAO.insertar(Moneda(0,"RWF","Rwandan Franc","Rwanda"))
                    monedaDAO.insertar(Moneda(0,"SAR","Saudi Riyal","Saudi Arabia"))
                    monedaDAO.insertar(Moneda(0,"SBD","Solomon Islands Dollar","Solomon Islands"))
                    monedaDAO.insertar(Moneda(0,"SCR","Seychellois Rupee","Seychelles"))
                    monedaDAO.insertar(Moneda(0,"SDG","Sudanese Pound","Sudan"))
                    monedaDAO.insertar(Moneda(0,"SEK","Swedish Krona","Sweden"))
                    monedaDAO.insertar(Moneda(0,"SGD","Singapore Dollar","Singapore"))
                    monedaDAO.insertar(Moneda(0,"SHP","Saint Helena Pound","Saint Helena"))
                    monedaDAO.insertar(Moneda(0,"SLE","Sierra Leonean Leone","Sierra Leone"))
                    monedaDAO.insertar(Moneda(0,"SOS","Somali Shilling","Somalia"))
                    monedaDAO.insertar(Moneda(0,"SRD","Surinamese Dollar","Suriname"))
                    monedaDAO.insertar(Moneda(0,"SSP","South Sudanese Pound","South Sudan"))
                    monedaDAO.insertar(Moneda(0,"STN","São Tomé and Príncipe Dobra","São Tomé and Príncipe"))
                    monedaDAO.insertar(Moneda(0,"SYP","Syrian Pound","Syria"))
                    monedaDAO.insertar(Moneda(0,"SZL","Eswatini Lilangeni","Eswatini"))
                    monedaDAO.insertar(Moneda(0,"THB","Thai Baht","Thailand"))
                    monedaDAO.insertar(Moneda(0,"TJS","Tajikistani Somoni","Tajikistan"))
                    monedaDAO.insertar(Moneda(0,"TMT","Turkmenistan Manat","Turkmenistan"))
                    monedaDAO.insertar(Moneda(0,"TND","Tunisian Dinar","Tunisia"))
                    monedaDAO.insertar(Moneda(0,"TOP","Tongan Paʻanga","Tonga"))
                    monedaDAO.insertar(Moneda(0,"TRY","Turkish Lira","Turkey"))
                    monedaDAO.insertar(Moneda(0,"TTD","Trinidad and Tobago Dollar","Trinidad and Tobago"))
                    monedaDAO.insertar(Moneda(0,"TVD","Tuvaluan Dollar","Tuvalu"))
                    monedaDAO.insertar(Moneda(0,"TWD","New Taiwan Dollar","Taiwan"))
                    monedaDAO.insertar(Moneda(0,"TZS","Tanzanian Shilling","Tanzania"))
                    monedaDAO.insertar(Moneda(0,"UAH","Ukrainian Hryvnia","Ukraine"))
                    monedaDAO.insertar(Moneda(0,"UGX","Ugandan Shilling","Uganda"))
                    monedaDAO.insertar(Moneda(0,"USD","United States Dollar","United States"))
                    monedaDAO.insertar(Moneda(0,"UYU","Uruguayan Peso","Uruguay"))
                    monedaDAO.insertar(Moneda(0,"UZS","Uzbekistani So'm","Uzbekistan"))
                    monedaDAO.insertar(Moneda(0,"VES","Venezuelan Bolívar Soberano","Venezuela"))
                    monedaDAO.insertar(Moneda(0,"VND","Vietnamese Đồng","Vietnam"))
                    monedaDAO.insertar(Moneda(0,"VUV","Vanuatu Vatu","Vanuatu"))
                    monedaDAO.insertar(Moneda(0,"WST","Samoan Tālā","Samoa"))
                    monedaDAO.insertar(Moneda(0,"XAF","Central African CFA Franc","CEMAC"))
                    monedaDAO.insertar(Moneda(0,"XCD","East Caribbean Dollar","Organisation of Eastern Caribbean States"))
                    monedaDAO.insertar(Moneda(0,"XDR","Special Drawing Rights","International Monetary Fund"))
                    monedaDAO.insertar(Moneda(0,"XOF","West African CFA franc","CFA"))
                    monedaDAO.insertar(Moneda(0,"XPF","CFP Franc","Collectivités d'Outre-Mer"))
                    monedaDAO.insertar(Moneda(0,"YER","Yemeni Rial","Yemen"))
                    monedaDAO.insertar(Moneda(0,"ZAR","South African Rand","South Africa"))
                    monedaDAO.insertar(Moneda(0,"ZMW","Zambian Kwacha","Zambia"))
                    monedaDAO.insertar(Moneda(0,"ZWL","Zimbabwean Dollar","Zimbabwe"))

                }
            }

        }
    }

    companion object{
        @Volatile
        private var INSTANCE: MonedasDB?=null

        val databaseexecutor :
                ExecutorService =
            Executors.newFixedThreadPool(4)

        fun getDatabase(context: Context, scope: CoroutineScope): MonedasDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context, MonedasDB::class.java,
                    "midbmonedas"
                ).addCallback(MonedasDBCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

