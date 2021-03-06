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

                if (myAdapter.getItem(position).getTitle() == "????????? ??????") {
                    Intent intent = new Intent(getContext(), dalgonaActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "?????? ??????") {
                    Intent intent = new Intent(getContext(), StrawberryLatteActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "???????????????") {
                    Intent intent = new Intent(getContext(), zamongadeActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "????????? ?????????") {
                    Intent intent = new Intent(getContext(), orangeadeActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "????????? ?????????") {
                    Intent intent = new Intent(getContext(), bananasmoothieActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "?????? ???????????????") {
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

        recipeList.add(new SampleData(R.drawable.drink_dalgona, "????????? ??????","?????? ?????? 1???, ????????? ??? 1/4???, ?????? ??? ??????, ??????"));
        recipeList.add(new SampleData(R.drawable.drink_strawberrylatte, "?????? ??????","?????? 13???(5??? ??????), ??????, ???(????????? ??????), ??????"));
        recipeList.add(new SampleData(R.drawable.drink_jamongade, "???????????????","?????? 1???, ???????????? 1?????????, ?????? ??????, ??? 2~3??????, ?????????"));
        recipeList.add(new SampleData(R.drawable.drink_orangeade, "????????? ?????????","????????? 1???, ????????? 1?????????, ??????????????? 2?????????, ????????? 150~200ml"));
        recipeList.add(new SampleData(R.drawable.drink_bananasmoothie, "????????? ?????????","?????????, ??????, ??????, ?????????"));
        recipeList.add(new SampleData(R.drawable.drink_bluelemonade, "?????? ???????????????","?????? 1~1.5???, ?????? ????????? ?????? 20ml, ??????????????? 20~30ml, ????????? 30ml, ??????"));
    }
    @Override
    public void onBackPressed() {
        goToMain();
    }

    private void goToMain() {
        ((MainActivity)getActivity()).replace(ContentFragment.newInstance(res));

    }

}
