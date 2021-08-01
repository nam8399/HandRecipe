package recipeinhand.com.sidemenu.sample;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import recipeinhand.com.sidemenu.sample.fragment.ContentFragment;
import recipeinhand.com.sidemenu.sample.recipe.desert.onepantoastActivity;
import recipeinhand.com.sidemenu.sample.recipe.desert.riceburgerActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.StrawberryLatteActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.bananasmoothieActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.bluelemonadeActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.dalgonaActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.zamongadeActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.cheeserabokeeActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.creampastaActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.creamshrimpActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchinoodleActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchiriceActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchizzigaeActivity;

public class SearchActivity extends AppCompatActivity {

    ArrayList<SampleData> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView edittostring;
        String tag;

        Intent intent = getIntent();
        tag = intent.getExtras().getString("onclick");
        recipeList = new ArrayList<SampleData>();
        if (tag.contains("김치")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);

            if (tag.contains("김치볶")) {
                recipeList.add(new SampleData(R.drawable.food_kimchirice, "베이컨 김치볶음밥","베이컨 4줄, 신김치 1컵, 대파 1/2대,  밥 한공기, 진간장 1스푼"));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/

                        if (myAdapter.getItem(position).getTitle() == "베이컨 김치볶음밥") {
                            Intent intent = new Intent(getApplicationContext(), kimchiriceActivity.class);
                            startActivity(intent);
                        }}
                });
            }
            else if (tag.contains("김치찌")) {
                recipeList.add(new SampleData(R.drawable.food_kimchizzigae, "참치 김치찌개","신김치 1/4포기, 양파 반개, 대파 1대, 청양고추 1개, 참치 100g 1캔, 올리브유 1스푼, 고춧가루 1작은술, 설탕 0.5큰술, 육수 700~700ml"));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/

                        if (myAdapter.getItem(position).getTitle() == "참치 김치찌개") {
                            Intent intent = new Intent(getApplicationContext(), kimchizzigaeActivity.class);
                            startActivity(intent);
                        }}
                });
            }
            else {
                recipeList.add(new SampleData(R.drawable.food_kimchirice, "베이컨 김치볶음밥","베이컨 4줄, 신김치 1컵, 대파 1/2대,  밥 한공기, 진간장 1스푼"));
                recipeList.add(new SampleData(R.drawable.food_kimchinoodle, "김치칼국수","칼국수면 1인분, 김치 1/2컵, 김치국물 1/4컵, 멸치 다시 육수 5~6컵, 만두 4개, 국간장 1/2스푼, 다진마늘 1/4스푼"));
                recipeList.add(new SampleData(R.drawable.food_kimchizzigae, "참치 김치찌개","신김치 1/4포기, 양파 반개, 대파 1대, 청양고추 1개, 참치 100g 1캔, 올리브유 1스푼, 고춧가루 1작은술, 설탕 0.5큰술, 육수 700~700ml"));

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/

                        if (myAdapter.getItem(position).getTitle() == "베이컨 김치볶음밥") {
                            Intent intent = new Intent(getApplicationContext(), kimchiriceActivity.class);
                            startActivity(intent);
                        }
                        if (myAdapter.getItem(position).getTitle() == "김치칼국수") {
                            Intent intent = new Intent(getApplicationContext(), kimchinoodleActivity.class);
                            startActivity(intent);
                        }
                        if (myAdapter.getItem(position).getTitle() == "참치 김치찌개") {
                            Intent intent = new Intent(getApplicationContext(), kimchizzigaeActivity.class);
                            startActivity(intent);
                        }

                    }
                });

            }
        }
        else if (tag.contains("칼국수")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.food_kimchinoodle, "김치칼국수","칼국수면 1인분, 김치 1/2컵, 김치국물 1/4컵, 멸치 다시 육수 5~6컵, 만두 4개, 국간장 1/2스푼, 다진마늘 1/4스푼"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/

                    if (myAdapter.getItem(position).getTitle() == "김치칼국수") {
                        Intent intent = new Intent(getApplicationContext(), kimchinoodleActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("베이컨")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.food_kimchirice, "베이컨 김치볶음밥","베이컨 4줄, 신김치 1컵, 대파 1/2대,  밥 한공기, 진간장 1스푼"));
            recipeList.add(new SampleData(R.drawable.food_creampasta, "베이컨 크림파스타","마늘 7~8알, 양파 반개, 베이컨 200g, 양송이버섯 5~6개 슬라이스, 파스타면 2인분, 올리브오일, 허브솔트, 시판 크림파스타소스 200g, 우유 100ml"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "베이컨 크림파스타") {
                        Intent intent = new Intent(getApplicationContext(), creampastaActivity.class);
                        startActivity(intent);
                    }
                    if (myAdapter.getItem(position).getTitle() == "베이컨 김치볶음밥") {
                        Intent intent = new Intent(getApplicationContext(), kimchiriceActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("크림")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.food_creamshrimp, "크림 새우","새우, 치커리, 튀김가루 1컵, 올리브오일 30g, 식용유, 마요네즈, 식초, 설탕"));
            recipeList.add(new SampleData(R.drawable.food_creampasta, "베이컨 크림파스타","마늘 7~8알, 양파 반개, 베이컨 200g, 양송이버섯 5~6개 슬라이스, 파스타면 2인분, 올리브오일, 허브솔트, 시판 크림파스타소스 200g, 우유 100ml"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "베이컨 크림파스타") {
                        Intent intent = new Intent(getApplicationContext(), creampastaActivity.class);
                        startActivity(intent);
                    }
                    if (myAdapter.getItem(position).getTitle() == "크림 새우") {
                        Intent intent = new Intent(getApplicationContext(), creamshrimpActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("새우")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.food_creamshrimp, "크림 새우","새우, 치커리, 튀김가루 1컵, 올리브오일 30g, 식용유, 마요네즈, 식초, 설탕"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "크림 새우") {
                        Intent intent = new Intent(getApplicationContext(), creamshrimpActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("치즈")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.food_cheeserabokee, "치즈 라볶이","라면한봉지, 떡국떡한줌, 어묵2장, 치즈1장, 라면스프3/4, 고추장 1.5큰술, 설탕 1.5큰술"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "치즈 라볶이") {
                        Intent intent = new Intent(getApplicationContext(),cheeserabokeeActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("라볶이")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.food_cheeserabokee, "치즈 라볶이","라면한봉지, 떡국떡한줌, 어묵2장, 치즈1장, 라면스프3/4, 고추장 1.5큰술, 설탕 1.5큰술"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "치즈 라볶이") {
                        Intent intent = new Intent(getApplicationContext(),cheeserabokeeActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("달고나")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_dalgona, "달고나 커피","커피 스틱 1개, 따뜻한 물 1/4컵, 설탕 세 스푼, 우유"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "달고나 커피") {
                        Intent intent = new Intent(getApplicationContext(), dalgonaActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("커피")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_dalgona, "달고나 커피","커피 스틱 1개, 따뜻한 물 1/4컵, 설탕 세 스푼, 우유"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "달고나 커피") {
                        Intent intent = new Intent(getApplicationContext(), dalgonaActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("딸기")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_strawberrylatte, "딸기 라떼","딸기 13개(5잔 분량), 설탕, 물(종이컵 반컵), 우유"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "딸기 라떼") {
                        Intent intent = new Intent(getApplicationContext(), StrawberryLatteActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("자몽")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_jamongade, "자몽에이드","자몽 1개, 스테비아 1티스푼, 얼음 약간, 물 2~3큰술, 탄산수"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "자몽에이드") {
                        Intent intent = new Intent(getApplicationContext(), zamongadeActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("라떼")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_strawberrylatte, "딸기 라떼","딸기 13개(5잔 분량), 설탕, 물(종이컵 반컵), 우유"));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "딸기 라떼") {
                        Intent intent = new Intent(getApplicationContext(), StrawberryLatteActivity.class);
                        startActivity(intent);
                    }}
            });
        }
        else if (tag.contains("에이드")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_jamongade, "자몽에이드","자몽 1개, 스테비아 1티스푼, 얼음 약간, 물 2~3큰술, 탄산수"));
            recipeList.add(new SampleData(R.drawable.drink_orangeade, "오렌지 에이드","오렌지 1개, 레몬즙 1티스푼, 아가베시럽 2티스푼, 탄산수 150~200ml"));
            recipeList.add(new SampleData(R.drawable.drink_bluelemonade, "블루 레몬에이드","레몬 1~1.5개, 블류 큐라소 시럽 20ml, 아가베시럽 20~30ml, 탄산수 30ml, 얼음"));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "딸기 라떼") {
                        Intent intent = new Intent(getApplicationContext(), StrawberryLatteActivity.class);
                        startActivity(intent);
                    }
                    if (myAdapter.getItem(position).getTitle() == "자몽에이드") {
                        Intent intent = new Intent(getApplicationContext(), zamongadeActivity.class);
                        startActivity(intent);
                    }
                    if (myAdapter.getItem(position).getTitle() == "블루 레몬에이드") {
                        Intent intent = new Intent(getApplicationContext(), bluelemonadeActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
        else if (tag.contains("바나나")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_bananasmoothie, "바나나 스무디","바나나, 연유, 우유, 믹서기"));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "바나나") {
                        Intent intent = new Intent(getApplicationContext(), bananasmoothieActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
        else if (tag.contains("스무디")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_bananasmoothie, "바나나 스무디","바나나, 연유, 우유, 믹서기"));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "바나나") {
                        Intent intent = new Intent(getApplicationContext(), bananasmoothieActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
        else if (tag.contains("레몬")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.drink_bluelemonade, "블루 레몬에이드","레몬 1~1.5개, 블류 큐라소 시럽 20ml, 아가베시럽 20~30ml, 탄산수 30ml, 얼음"));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "블루 레몬에이드") {
                        Intent intent = new Intent(getApplicationContext(), bluelemonadeActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
        else if (tag.contains("밥")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);

            if (tag.contains("밥버거")) {
                recipeList.add(new SampleData(R.drawable.desert_riceburger, "밥버거","캔참치 150g, 자른김치 200g, 슬라이스치즈, 김, 양파 50g, 밥"));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/

                        if (myAdapter.getItem(position).getTitle() == "밥버거") {
                            Intent intent = new Intent(getApplicationContext(), riceburgerActivity.class);
                            startActivity(intent);
                        }}
                });
            }
            else {
                recipeList.add(new SampleData(R.drawable.food_kimchirice, "베이컨 김치볶음밥","베이컨 4줄, 신김치 1컵, 대파 1/2대,  밥 한공기, 진간장 1스푼"));
                recipeList.add(new SampleData(R.drawable.desert_riceburger, "밥버거","캔참치 150g, 자른김치 200g, 슬라이스치즈, 김, 양파 50g, 밥"));

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                        if (myAdapter.getItem(position).getTitle() == "베이컨 김치볶음밥") {
                            Intent intent = new Intent(getApplicationContext(), kimchiriceActivity.class);
                            startActivity(intent);
                        }
                        if (myAdapter.getItem(position).getTitle() == "밥버거") {
                            Intent intent = new Intent(getApplicationContext(), riceburgerActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }

        }
        else if (tag.contains("계란")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.desert_onepantoast, "원팬 계란토스트","식빵 1장, 계란 2개, 체다슬라이스치즈 1장, 설탕, 소금"));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "원팬 계란토스트") {
                        Intent intent = new Intent(getApplicationContext(), onepantoastActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
        else if (tag.contains("토스트")) {
            ListView listView = (ListView)findViewById(R.id.listview_list);
            final MyAdapter myAdapter = new MyAdapter(this,recipeList);

            listView.setAdapter(myAdapter);
            recipeList.add(new SampleData(R.drawable.desert_onepantoast, "원팬 계란토스트","식빵 1장, 계란 2개, 체다슬라이스치즈 1장, 설탕, 소금"));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/
                    if (myAdapter.getItem(position).getTitle() == "원팬 계란토스트") {
                        Intent intent = new Intent(getApplicationContext(), onepantoastActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
        else {
            Toast.makeText(this,"검색결과가 없습니다.",Toast.LENGTH_SHORT).show();
        }





/*
        if (tag.contains("김치")) {
            recipeList = new ArrayList<SampleData>();

            recipeList.add(new SampleData(R.drawable.food_kimchinoodle, "김치칼국수","김치랑 칼국수"));
            recipeList.add(new SampleData(R.drawable.food_kimchirice, "김치볶음밥","김치랑 볶음밥"));
            recipeList.add(new SampleData(R.drawable.food_kimchizzigae, "김치찌개","김치랑 물"));

        }
*/
    }


    public void onBackPressed() {
        goToMain();
    }

    private void goToMain() {
        finish();


    }


}