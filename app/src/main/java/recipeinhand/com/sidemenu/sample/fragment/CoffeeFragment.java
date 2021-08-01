package recipeinhand.com.sidemenu.sample.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import recipeinhand.com.sidemenu.sample.MainActivity;
import recipeinhand.com.sidemenu.sample.MyAdapter;
import recipeinhand.com.sidemenu.sample.R;
import recipeinhand.com.sidemenu.sample.SampleData;
import recipeinhand.com.sidemenu.sample.onBackPressedListener;
import recipeinhand.com.sidemenu.sample.recipe.drink.StrawberryLatteActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.bananasmoothieActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.bluelemonadeActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.dalgonaActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.orangeadeActivity;
import recipeinhand.com.sidemenu.sample.recipe.drink.zamongadeActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.cheeserabokeeActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.creampastaActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.creamshrimpActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchinoodleActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchiriceActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchizzigaeActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoffeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoffeeFragment extends Fragment implements onBackPressedListener {
    public static final String COFFEE = "Coffee";
    protected int res;

    ArrayList<SampleData> recipeList;

    public static CoffeeFragment newInstance(int resId) {
        CoffeeFragment coffeeFragment = new CoffeeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        coffeeFragment.setArguments(bundle);
        return coffeeFragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //this.containerView = view.findViewById(R.id.container);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getArguments().getInt(Integer.class.getName());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coffee, container, false);

        this.InitializeRecipeData();

        ListView listView = (ListView)rootView.findViewById(R.id.listview_list);
        final MyAdapter myAdapter = new MyAdapter(getContext(),recipeList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                /*Toast.makeText(getContext(),
                        myAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_LONG).show();*/

                if (myAdapter.getItem(position).getTitle() == "달고나 커피") {
                    Intent intent = new Intent(getContext(), dalgonaActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "딸기 라떼") {
                    Intent intent = new Intent(getContext(), StrawberryLatteActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "자몽에이드") {
                    Intent intent = new Intent(getContext(), zamongadeActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "오렌지 에이드") {
                    Intent intent = new Intent(getContext(), orangeadeActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "바나나 스무디") {
                    Intent intent = new Intent(getContext(), bananasmoothieActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "블루 레몬에이드") {
                    Intent intent = new Intent(getContext(), bluelemonadeActivity.class);
                    startActivity(intent);
                }

            }
        });

        return rootView;
    }

    public void InitializeRecipeData()
    {
        recipeList = new ArrayList<SampleData>();

        recipeList.add(new SampleData(R.drawable.drink_dalgona, "달고나 커피","커피 스틱 1개, 따뜻한 물 1/4컵, 설탕 세 스푼, 우유"));
        recipeList.add(new SampleData(R.drawable.drink_strawberrylatte, "딸기 라떼","딸기 13개(5잔 분량), 설탕, 물(종이컵 반컵), 우유"));
        recipeList.add(new SampleData(R.drawable.drink_jamongade, "자몽에이드","자몽 1개, 스테비아 1티스푼, 얼음 약간, 물 2~3큰술, 탄산수"));
        recipeList.add(new SampleData(R.drawable.drink_orangeade, "오렌지 에이드","오렌지 1개, 레몬즙 1티스푼, 아가베시럽 2티스푼, 탄산수 150~200ml"));
        recipeList.add(new SampleData(R.drawable.drink_bananasmoothie, "바나나 스무디","바나나, 연유, 우유, 믹서기"));
        recipeList.add(new SampleData(R.drawable.drink_bluelemonade, "블루 레몬에이드","레몬 1~1.5개, 블류 큐라소 시럽 20ml, 아가베시럽 20~30ml, 탄산수 30ml, 얼음"));
    }
    @Override
    public void onBackPressed() {
        goToMain();
    }

    private void goToMain() {
        ((MainActivity)getActivity()).replace(ContentFragment.newInstance(res));

    }

}
