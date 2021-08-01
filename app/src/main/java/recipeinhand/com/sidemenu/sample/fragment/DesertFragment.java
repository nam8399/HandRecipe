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
import android.widget.TextView;

import java.util.ArrayList;

import recipeinhand.com.sidemenu.sample.MainActivity;
import recipeinhand.com.sidemenu.sample.MyAdapter;
import recipeinhand.com.sidemenu.sample.R;
import recipeinhand.com.sidemenu.sample.SampleData;
import recipeinhand.com.sidemenu.sample.onBackPressedListener;
import recipeinhand.com.sidemenu.sample.recipe.desert.onepantoastActivity;
import recipeinhand.com.sidemenu.sample.recipe.desert.riceburgerActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.cheeserabokeeActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.creampastaActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.creamshrimpActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchinoodleActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchiriceActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchizzigaeActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DesertFragment extends Fragment implements onBackPressedListener {
    public static final String RICE = "Rice";
    protected int res;
    public static final String CAKE = "Fastfood";

    ArrayList<SampleData> recipeList;


    public static DesertFragment newInstance(int resId) {
        DesertFragment desertFragment = new DesertFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        desertFragment.setArguments(bundle);
        return desertFragment;
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
        View rootView = inflater.inflate(R.layout.fragment_dersert, container, false);

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

                if (myAdapter.getItem(position).getTitle() == "밥버거") {
                    Intent intent = new Intent(getContext(), riceburgerActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "원팬 계란토스트") {
                    Intent intent = new Intent(getContext(), onepantoastActivity.class);
                    startActivity(intent);
                }
            }


        });


        recipeList = new ArrayList<SampleData>();









        return rootView;
    }

    public void InitializeRecipeData()
    {
        recipeList = new ArrayList<SampleData>();

        recipeList.add(new SampleData(R.drawable.desert_riceburger, "밥버거","캔참치 150g, 자른김치 200g, 슬라이스치즈, 김, 양파 50g, 밥"));
        recipeList.add(new SampleData(R.drawable.desert_onepantoast, "원팬 계란토스트","식빵 1장, 계란 2개, 체다슬라이스치즈 1장, 설탕, 소금"));
    }
    @Override
    public void onBackPressed() {
        goToMain();
    }

    private void goToMain() {
        ((MainActivity)getActivity()).replace(ContentFragment.newInstance(res));

    }

}