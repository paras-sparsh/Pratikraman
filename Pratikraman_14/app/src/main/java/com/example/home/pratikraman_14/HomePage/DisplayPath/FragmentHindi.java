package com.example.home.pratikraman_14.HomePage.DisplayPath;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.home.pratikraman_14.HomePage.Path;
import com.example.home.pratikraman_14.R;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentHindi extends Fragment {
    ArrayList<Path> completeList;
    CustomPagerAdapter mCustomPagerAdapter;


    public FragmentHindi() {


        //mViewPager = (ViewPager) findViewById(R.id.pager);

//        mViewPager.setAdapter(mCustomPagerAdapter);
//        mViewPager.setCurrentItem(getTheObject(pos));
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_path, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String position = bundle.getString("position");
            setData(position);
        }
    }

    public void setData(String pos) {
        ViewPager viewPager = (ViewPager)getView().findViewById(R.id.view_pager);
        createList();
        mCustomPagerAdapter = new CustomPagerAdapter(getContext(), completeList);
        viewPager.setAdapter(mCustomPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                getActivity().setTitle(completeList.get(position).getTitle());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(getTheObject(pos));
        //try {

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public int getTheObject(String pos) {
        for (int i =0;i<completeList.size();i++){
            if (completeList.get(i).getId().equalsIgnoreCase(pos)) {
                return i;
            }
        }
        return -1;
    }

    public void createList() {
        completeList = new ArrayList<>();
        completeList.addAll(createparentListForFirst());
        completeList.addAll(createparentListForSecond());
        completeList.addAll(createparentListForThird());
        completeList.addAll(createparentListForFourth());
        completeList.addAll(createparentListForFifth());
        completeList.addAll(createparentListForSixth());
        completeList.addAll(createparentListForSeventh());
        completeList.addAll(createparentListForEighth());
    }

    public ArrayList<Path> createparentListForFirst() {
        Path p1 = new Path("1",this.getResources().getString(R.string.title_chauvisathav_ka_path),this.getResources().getString(R.string.text_chauvisathav_ka_path),R.raw.chauvistva_agyaa);
        Path p2 = new Path("2",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p3 = new Path("3",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);
        Path p4 = new Path("4",this.getResources().getString(R.string.title_eng_Irrayavahia),this.getResources().getString(R.string.text_eng_Iriyavahia),R.raw.chauvistva_icchakarenam);
        Path p5 = new Path("5",this.getResources().getString(R.string.title_eng_Tassauttari),this.getResources().getString(R.string.text_eng_Tassauttari),R.raw.chauvistva_tassa_uttari);
        Path p6 = new Path("6",this.getResources().getString(R.string.title_eng_Logassa),this.getResources().getString(R.string.text_eng_Logassa),R.raw.chauvistva_dhyaan_logassa_do_bar);
        Path p7 = new Path("7",this.getResources().getString(R.string.title_eng_dhyan),this.getResources().getString(R.string.text_eng_dhyan),R.raw.chauvistva_char_dhyaan);
        Path p9 = new Path("3001",this.getResources().getString(R.string.title_eng_Logassa),this.getResources().getString(R.string.text_eng_Logassa),R.raw.chauvistva_logassa);
        Path p8 = new Path("9",this.getResources().getString(R.string.title_eng_Nammotthunam),this.getResources().getString(R.string.text_eng_Nammotthunam),R.raw.chauvistva_namutthunam);
        Path p10 = new Path("3002",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);

        ArrayList<Path> parentList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p10,p7,p9,p8));
        return parentList;
    }

    public ArrayList<Path> createparentListForSecond() {
        Path p1 = new Path("10",this.getResources().getString(R.string.title_devasi_pratikraman_karne_ki_aadnyaa),this.getResources().getString(R.string.text_devsi_pratikraman_ki_agya),R.raw.agyaa_devsi_pratikraman);
        Path p2 = new Path("11",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p3 = new Path("12",this.getResources().getString(R.string.title_ichhaminam_bhante_ka_path),this.getResources().getString(R.string.text_ichhaminam_bhante_ka_path),R.raw.agyaa_ecchami_nama_bhante);
        Path p4 = new Path("13",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);
        ArrayList<Path> parentList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4));
        return parentList;
    }

    public ArrayList<Path> createparentListForThird() {
        Path p1 = new Path("14",this.getResources().getString(R.string.title_pratham_aavayshyak),this.getResources().getString(R.string.text_pratham_avashyak_ki_aadnyaa),R.raw.samayik_pehla_aavyshyak_agyaa);
        Path p2 = new Path("15",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p3 = new Path("16",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);
        Path p4 = new Path("17",this.getResources().getString(R.string.title_eng_KaremiBhante),this.getResources().getString(R.string.text_eng_KaremiBhante),R.raw.samayik_karemi_bhante);
        Path p5 = new Path("18",this.getResources().getString(R.string.title_ichhami_thami_ka_path),this.getResources().getString(R.string.text_ichhami_thami_ka_path),R.raw.samayik_icchami_thami);
        Path p6 = new Path("19",this.getResources().getString(R.string.title_eng_Tassauttari),this.getResources().getString(R.string.text_eng_Tassauttari),R.raw.samayik_tassa_uttari);
        Path p7 = new Path("20",this.getResources().getString(R.string.title_dnyan_ka_atichar_ka_path),this.getResources().getString(R.string.text_dnyan_ke_atichar_ka_path),R.raw.pratikraman_agme_tivehe_panate);
        Path p8 = new Path("21",this.getResources().getString(R.string.title_darshan_samyaktva_ka_path),this.getResources().getString(R.string.text_darshan_samyaktva_ka_path),R.raw.samayik_arihant_mahadevo);
        //Path p9 = new Path("22",this.getResources().getString(R.string.title_barah_sthool),"");
        Path p14 = new Path("27",this.getResources().getString(R.string.title_pehla_sthool_pranatipat_virman_vrat),this.getResources().getString(R.string.text_pehla_sthool),R.raw.samayik_sthool_one);
        Path p15 = new Path("28",this.getResources().getString(R.string.title_duja_sthool_mrushawad_virman_vrat),this.getResources().getString(R.string.text_duja_sthool),R.raw.samayik_sthool_two);
        Path p16 = new Path("29",this.getResources().getString(R.string.title_tija_sthool_adattadan),this.getResources().getString(R.string.text_tija_sthool),R.raw.samayik_sthool_three);
        Path p17 = new Path("30",this.getResources().getString(R.string.title_chautha_sthool_swadar_santosh_pardar_vivarjan_swapati_santosh_parpurush_vivarjan_roop_maithun_virman_vrat),this.getResources().getString(R.string.text_chautha_sthool),R.raw.samayik_sthool_four);
        Path p18 = new Path("31",this.getResources().getString(R.string.title_panchava_sthool_parigrah_pariman_vrat),this.getResources().getString(R.string.text_panchava_sthool),R.raw.samayik_sthool_five);
        Path p19 = new Path("32",this.getResources().getString(R.string.title_chattha_dishivrat),this.getResources().getString(R.string.text_chatthe_dishivrat_sthool),R.raw.samayik_sthool_six);
        Path p20 = new Path("33",this.getResources().getString(R.string.title_satava_upbhog_paribhog_pariman_vrat),this.getResources().getString(R.string.text_satava_upbhog_paribhog_pariman_vrat_sthool),R.raw.samayik_sthool_seven);

        Path p21 = new Path("34",this.getResources().getString(R.string.title_pandrah_karmadan),this.getResources().getString(R.string.text_pandrah_karmadan),R.raw.samayik_pandrah_karmadan);
        Path p22 = new Path("35",this.getResources().getString(R.string.title_athave_anarthadand_virman_vrat),this.getResources().getString(R.string.text_athave_anarthadand_virman_vrat_sthool),R.raw.samayik_sthool_eight);
        Path p23 = new Path("36",this.getResources().getString(R.string.title_navave_samayik_vrat),this.getResources().getString(R.string.text_navave_samayik_vrat_sthool),R.raw.samayik_sthool_nine);
        Path p24 = new Path("37",this.getResources().getString(R.string.title_dasave_desavagasik_vrat),this.getResources().getString(R.string.text_dasave_desavagasik_vrat_sthool),R.raw.samayik_sthool_ten);
        Path p25 = new Path("38",this.getResources().getString(R.string.title_gyarahva_padipunna_paushadh_vrat),this.getResources().getString(R.string.text_gyarhave_padipunna_paushadh_vrat_sthool),R.raw.samayik_sthool_eleven);
        Path p26 = new Path("39",this.getResources().getString(R.string.title_barahva_atithi_samvibhag_vrat),this.getResources().getString(R.string.text_barhave_atithi_samvibhag_vrat_sthool),R.raw.samayik_sthool_twelve);

        Path p10 = new Path("23",this.getResources().getString(R.string.title_sanlekhana_ke_panch_atichar_ka_path),this.getResources().getString(R.string.text_sanlekhana_ke_panch_atichar_ka_path),R.raw.samayik_salekhana_ke_atichar);
        Path p11 = new Path("24",this.getResources().getString(R.string.title_attharah_papsthan_ka_path),this.getResources().getString(R.string.text_attharah_papsthan_ka_path),R.raw.samayik_atharah_papasthan);
        Path p12 = new Path("25",this.getResources().getString(R.string.title_ichhami_thami_ka_path),this.getResources().getString(R.string.text_icchami_thami_ka_path_without_micchami),R.raw.samayik_dhyaan_mai_icchami_thami);
        Path p13 = new Path("26",this.getResources().getString(R.string.title_eng_dhyan),this.getResources().getString(R.string.text_eng_dhyan),R.raw.chauvistva_char_dhyaan);
        Path p27 = new Path("2010",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);

        ArrayList<Path> parentList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p10,p11,p12,p27,p13));
        return parentList;
    }

    public ArrayList<Path> createparentListForFourth() {
        Path p1 = new Path("40",this.getResources().getString(R.string.title_dusre_aavayshyak),this.getResources().getString(R.string.text_dusare_aavashyak_ki_aadnyaa),R.raw.dusre_aavyshak_ki_agyaa);
        Path p2 = new Path("41",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p3 = new Path("42",this.getResources().getString(R.string.title_eng_Logassa),this.getResources().getString(R.string.text_eng_Logassa),R.raw.chauvistva_logassa);

        ArrayList<Path> parentList = new ArrayList<>(Arrays.asList(p1,p2,p3));
        return parentList;
    }

    public ArrayList<Path> createparentListForFifth() {
        Path p1 = new Path("43",this.getResources().getString(R.string.title_tije_aavayshyak),this.getResources().getString(R.string.text_teesare_aavashyak_ki_aadnyaa),R.raw.tisre_aavshyak_ki_agyaa);
        Path p2 = new Path("44",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p3 = new Path("45",this.getResources().getString(R.string.title_ichhami_khamasamno_ka_path),this.getResources().getString(R.string.text_ichhami_khamasamno_ka_path),R.raw.icchami_khamsamno);

        ArrayList<Path> parentList = new ArrayList<>(Arrays.asList(p1,p2,p3));
        return parentList;
    }

    public ArrayList<Path> createparentListForSixth() {
        Path p1 = new Path("46",this.getResources().getString(R.string.title_chautha_avashyak),this.getResources().getString(R.string.text_chauthe_aavashyak_ki_aadnyaa),R.raw.chouthe_aavyshak_ki_agyaa);
        Path p2 = new Path("47",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p3 = new Path("48",this.getResources().getString(R.string.title_dnyan_ka_atichar_ka_path),this.getResources().getString(R.string.text_dnyan_ke_atichar_ka_path),R.raw.pratikraman_agme_tivehe_panate);
        Path p4 = new Path("49",this.getResources().getString(R.string.title_dansan_samkit_ka_path),this.getResources().getString(R.string.text_dansan_samkit_ka_path),R.raw.pratikraman_dasan_saamath_ka_path);
       // Path p5 = new Path("50",this.getResources().getString(R.string.title_barah_anuvrat),"",0);//Path p5 = new Path("50",this.getResources().getString(R.string.title_barah_anuvrat),"");

        Path b1 = new Path("76",this.getResources().getString(R.string.title_pahla_anuvrat),this.getResources().getString(R.string.text_pahla_anuvrat),R.raw.pratikraman_anuvrat_one);
        Path b2 = new Path("77",this.getResources().getString(R.string.title_duja_anuvrat),this.getResources().getString(R.string.text_duja_anuvrat),R.raw.pratikraman_anuvrat_two);
        Path b3 = new Path("78",this.getResources().getString(R.string.title_teeja_anuvrat),this.getResources().getString(R.string.text_teeja_anuvrat),R.raw.pratikraman_anuvrat_three);
        Path b4 = new Path("79",this.getResources().getString(R.string.title_chautha_anuvrat),this.getResources().getString(R.string.text_chautha_anuvrat),R.raw.pratikraman_anuvrat_four);
        Path b5 = new Path("80",this.getResources().getString(R.string.title_panchva_anuvrat),this.getResources().getString(R.string.text_panchva_anuvrat),R.raw.pratikraman_anuvrat_five);
        Path b6 = new Path("81",this.getResources().getString(R.string.title_chattha_dishivrat),this.getResources().getString(R.string.text_chattha_dishivrat),R.raw.pratikraman_anuvrat_six);
        Path b7 = new Path("82",this.getResources().getString(R.string.title_satava_vrat_upbhog_paribhogvihim),this.getResources().getString(R.string.text_satava_vrat_upbhog_paribhogvihim),R.raw.pratikraman_anuvrat_eight);
        Path b8 = new Path("83",this.getResources().getString(R.string.title_athave_anarthadand_virman_vrat),this.getResources().getString(R.string.text_athava_anatthadand_virman_vrat),R.raw.pratikraman_anuvrat_eight);
        Path b9 = new Path("84",this.getResources().getString(R.string.title_navva_samayik_vrat),this.getResources().getString(R.string.text_navva_samayik_vrat),R.raw.pratikraman_anuvrat_nine);
        Path b10 = new Path("85",this.getResources().getString(R.string.title_dasave_desavagasik_vrat),this.getResources().getString(R.string.text_dasva_deshavagasik_vrat),R.raw.pratikraman_anuvrat_ten);
        Path b11 = new Path("86",this.getResources().getString(R.string.title_gyarahva_padipunna_paushadh_vrat),this.getResources().getString(R.string.text_gyarahva_padipunna_paushadh_vrat),R.raw.pratikraman_anuvrat_eleven);
        Path b12 = new Path("87",this.getResources().getString(R.string.title_barah_anuvrat),this.getResources().getString(R.string.text_barahva_atithi_samvibhag_vrat),R.raw.pratikraman_anuvrat_twelve);


        Path p6 = new Path("51",this.getResources().getString(R.string.title_badi_sanlekhana_ka_path),this.getResources().getString(R.string.text_badi_sanlekhana_ka_path),R.raw.pratikraman_badi_salekhana);
        Path p7 = new Path("52",this.getResources().getString(R.string.title_samuchchhay_ka_path),this.getResources().getString(R.string.text_samuchchhay_ka_path),R.raw.pratikraman_samucchay);
        Path p8 = new Path("53",this.getResources().getString(R.string.title_attharah_papsthan_ka_path),this.getResources().getString(R.string.text_attharah_papsthan_ka_path),R.raw.samayik_atharah_papasthan);
        Path p9 = new Path("54",this.getResources().getString(R.string.title_chaudah_sthaan_samoorchchhim_manushya_ka_path),this.getResources().getString(R.string.text_chaudah_sthaan_samoorchchhim_manushya_ka_path),R.raw.pratikraman_choudah_sthan_saamurchim);
        Path p10 = new Path("55",this.getResources().getString(R.string.title_pacchis_mithyaatva_ka_paath),this.getResources().getString(R.string.text_pacchis_mithyaatva_ka_paath),R.raw.pratikraman_pacchis_mithyatva);
        Path p11 = new Path("56",this.getResources().getString(R.string.title_ichhami_thami_ka_path),this.getResources().getString(R.string.text_ichhami_thami_ka_path),R.raw.samayik_icchami_thami);

        Path p12 = new Path("57",this.getResources().getString(R.string.title_shraman_sutra_ki_agyaa),this.getResources().getString(R.string.text_shraman_sootra),R.raw.shraman_sutra_ki_agyaa);
        Path p13 = new Path("58",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);
        Path p14 = new Path("59",this.getResources().getString(R.string.title_karemi_bhante_ka_paath),this.getResources().getString(R.string.text_eng_KaremiBhante),R.raw.samayik_karemi_bhante);
        Path p15 = new Path("60",this.getResources().getString(R.string.title_maangalik),this.getResources().getString(R.string.text_maangalik),R.raw.mangalik_bada_marasa);
        Path p16 = new Path("61",this.getResources().getString(R.string.title_eng_Irrayavahia),this.getResources().getString(R.string.text_eng_Iriyavahia),R.raw.chauvistva_icchakarenam);
        Path p17 = new Path("62",this.getResources().getString(R.string.title_nidaradosh_nivurutti_ka_paath),this.getResources().getString(R.string.text_nidradosh_nivurutti_ka_paath),R.raw.nidradosh_nivruti_ka_path);
        Path p18 = new Path("63",this.getResources().getString(R.string.title_bhikshadosh_nivurutti_ka_paath),this.getResources().getString(R.string.text_bhikshadosh_nivurutti_ka_paath),R.raw.bhikshadosh_nivruti_ka_path);
        Path p19 = new Path("64",this.getResources().getString(R.string.title_svadhaay_tatha_pratilekhana_dosh_nivurutti_ka_paath),this.getResources().getString(R.string.text_svadhaay_tatha_pratilekhana_dosh_nivurutti_ka_paath),R.raw.swadhyay_tatha_pratilekhna_dosh);
        Path p20 = new Path("65",this.getResources().getString(R.string.title_33_bol_ka_paath),this.getResources().getString(R.string.text_teintes_bol_ka_paath),R.raw.tentees_bol);
        Path p21 = new Path("66",this.getResources().getString(R.string.title_nigranth_pravachan_ka_path),this.getResources().getString(R.string.text_nigranth_pravachan_ka_path),R.raw.nigrantha_chouvistva);
        Path p22 = new Path("67",this.getResources().getString(R.string.title_ichhami_khamasamno_ka_path),this.getResources().getString(R.string.text_ichhami_khamasamno_ka_path),R.raw.icchami_khamsamno);
        Path p23 = new Path("68",this.getResources().getString(R.string.title_bhav_vandana_ki_agyaa),this.getResources().getString(R.string.title_bhav_vandana_ki_agyaa),R.raw.bhaavvandana_agyaa);
        // Path p24 = new Path("69",this.getResources().getString(R.string.title_savaiya),"");

        Path a1 = new Path("88",this.getResources().getString(R.string.title_savaiya),this.getResources().getString(R.string.text_first_savaiya),R.raw.savaiyya_one);
        Path a2 = new Path("89",this.getResources().getString(R.string.title_savaiya),this.getResources().getString(R.string.text_second_savaiya),R.raw.savaiyya_two);
        Path a3 = new Path("90",this.getResources().getString(R.string.title_savaiya),this.getResources().getString(R.string.text_third_savaiyya),R.raw.savaiyya_three);
        Path a4 = new Path("91",this.getResources().getString(R.string.title_savaiya),this.getResources().getString(R.string.text_fourth_savaiyya),R.raw.savaiyya_four);
        Path a5 = new Path("92",this.getResources().getString(R.string.title_savaiya),this.getResources().getString(R.string.text_fifth_savaiyya),R.raw.savaiyya_five);
        Path a6 = new Path("93",this.getResources().getString(R.string.title_savaiya),this.getResources().getString(R.string.text_sixth_savaiya),R.raw.savaiyya_six);

        Path p25 = new Path("70",this.getResources().getString(R.string.title_doha),this.getResources().getString(R.string.text_doha),R.raw.pratikraman_doha);
        Path p26 = new Path("71",this.getResources().getString(R.string.title_ayariya_uvajjhaye_ka_path),this.getResources().getString(R.string.text_ayariya_uvajjhaye_ka_path),R.raw.khamatkhamna_path);
        Path p27 = new Path("72",this.getResources().getString(R.string.title_adhai_dweep_pandrah_kshetra_ka_path),this.getResources().getString(R.string.text_adhai_dweep_pandrah_kshetra_ka_path),R.raw.pratikraman_shravak_shravika_khamane_ka_path);
        Path p28 = new Path("73",this.getResources().getString(R.string.title_chaurasi_lakh_jivYoni_ka_path),this.getResources().getString(R.string.text_chaurasi_lakh_jivyoni_ka_path),R.raw.pratikraman_saath_lakh);
        Path p29 = new Path("74",this.getResources().getString(R.string.title_kulkodi_ko_khamane_ka_path),this.getResources().getString(R.string.text_kulkodi_ko_khamane_pa_path),R.raw.pratikraman_pruthvikay_ke_kodikul);
        Path p30 = new Path("75",this.getResources().getString(R.string.title_attharah_papsthan_ka_path),this.getResources().getString(R.string.text_attharah_papsthan_ka_path),R.raw.samayik_atharah_papasthan);

        Path p31 = new Path("2003",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p32 = new Path("2004",this.getResources().getString(R.string.title_ichhami_thami_ka_path),this.getResources().getString(R.string.text_ichhami_thami_ka_path),R.raw.samayik_icchami_thami);
        Path p33 = new Path("2005",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p34 = new Path("2006",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);

        ArrayList<Path> parentList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,p6,p7,p8,p9,p10,p11,p12,p2,p13,p14,p15,p11,p16,p17,p18,p19,p20,p21,p22,p23,p2,p13,a1,a2,a3,a4,a5,a6,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34));
        return parentList;
    }

    public ArrayList<Path> createparentListForSeventh() {
        Path p1 = new Path("95",this.getResources().getString(R.string.title_panchve_aavayshyak),this.getResources().getString(R.string.text_panchva_avashyak),R.raw.pachva_aavshyak);
        Path p2 = new Path("96",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p3 = new Path("97",this.getResources().getString(R.string.title_prayaschitt_ka_path),this.getResources().getString(R.string.text_prayaschitt_ka_path),R.raw.devsiyam_one_line);
        Path p4 = new Path("98",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);
        Path p5 = new Path("99",this.getResources().getString(R.string.title_eng_KaremiBhante),this.getResources().getString(R.string.text_eng_KaremiBhante),R.raw.samayik_karemi_bhante);
        Path p6 = new Path("100",this.getResources().getString(R.string.title_ichhami_thami_ka_path),this.getResources().getString(R.string.text_ichhami_thami_ka_path),R.raw.samayik_icchami_thami);
        Path p7 = new Path("101",this.getResources().getString(R.string.title_eng_Tassauttari),this.getResources().getString(R.string.text_eng_Tassauttari),R.raw.chauvistva_tassa_uttari);
        Path p8 = new Path("102",this.getResources().getString(R.string.title_logassa_dnyaan),this.getResources().getString(R.string.text_logassa_dnyaan),R.raw.dhyaan_logassa_instructions);
        Path p9 = new Path("103",this.getResources().getString(R.string.title_eng_Logassa),this.getResources().getString(R.string.text_eng_Logassa),R.raw.chauvistva_logassa);
        Path p10 = new Path("104",this.getResources().getString(R.string.title_eng_dhyan),this.getResources().getString(R.string.text_eng_dhyan),R.raw.chauvistva_char_dhyaan);
        Path p11 = new Path("105",this.getResources().getString(R.string.title_ichhami_khamasamno_ka_path),this.getResources().getString(R.string.text_ichhami_khamasamno_ka_path),R.raw.icchami_khamsamno);
        Path p12 = new Path("2001",this.getResources().getString(R.string.title_eng_navkar_mantra),this.getResources().getString(R.string.text_eng_navkar_mantra),R.raw.chauvistva_navkar_mantra);
        Path p13 = new Path("2002",this.getResources().getString(R.string.title_eng_Logassa),this.getResources().getString(R.string.text_eng_Logassa),R.raw.chauvistva_logassa);

        ArrayList<Path> parentList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p12,p10,p13,p11));
        return parentList;
    }

    public ArrayList<Path> createparentListForEighth() {
        Path p1 = new Path("106",this.getResources().getString(R.string.title_chatthe_aavashyak_ki_aadnya),this.getResources().getString(R.string.text_chatthe_aavashyak_ki_aadnya),R.raw.chatte_aavyshak_ki_agyaa);
        Path p2 = new Path("107",this.getResources().getString(R.string.title_eng_Tikkhuto),this.getResources().getString(R.string.text_eng_Tikkhuto),R.raw.thikhuto);
        Path p3 = new Path("108",this.getResources().getString(R.string.title_samuchhay_pachhakkhan_ka_path),this.getResources().getString(R.string.text_samuchhay_pachhakkhan_ka_path),R.raw.ganthiyam);
        Path p4 = new Path("109",this.getResources().getString(R.string.title_antim_path),this.getResources().getString(R.string.text_antim_path),R.raw.antim_path);
        Path p5 = new Path("110",this.getResources().getString(R.string.title_eng_Nammotthunam),this.getResources().getString(R.string.text_eng_Nammotthunam),R.raw.sham_saveg);
        Path p6 = new Path("111",this.getResources().getString(R.string.title_dnyan_ka_atichar_ka_path),this.getResources().getString(R.string.text_dnyan_ke_atichar_ka_path),R.raw.pratikraman_agme_tivehe_panate);
        ArrayList<Path> parentList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));
        return parentList;
    }
}