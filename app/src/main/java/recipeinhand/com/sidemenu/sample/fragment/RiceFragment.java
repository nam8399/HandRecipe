package recipeinhand.com.sidemenu.sample.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import recipeinhand.com.sidemenu.sample.MainActivity;
import recipeinhand.com.sidemenu.sample.MyAdapter;
import recipeinhand.com.sidemenu.sample.R;
import recipeinhand.com.sidemenu.sample.SampleData;
import recipeinhand.com.sidemenu.sample.onBackPressedListener;
import recipeinhand.com.sidemenu.sample.recipe.drink.dalgonaActivity;
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
public class RiceFragment extends Fragment implements onBackPressedListener {
    public static final String RICE = "Rice";
    protected int res;

    ArrayList<SampleData> recipeList;

    public static RiceFragment newInstance(int resId) {
        RiceFragment riceFragment = new RiceFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        riceFragment.setArguments(bundle);
        return riceFragment;
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
        View rootView = inflater.inflate(R.layout.fragment_rice, container, false);

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

                if (myAdapter.getItem(position).getTitle() == "베이컨 김치볶음밥") {
                    Intent intent = new Intent(getContext(), kimchiriceActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "김치칼국수") {
                    Intent intent = new Intent(getContext(), kimchinoodleActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "참치 김치찌개") {
                    Intent intent = new Intent(getContext(), kimchizzigaeActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "베이컨 크림파스타") {
                    Intent intent = new Intent(getContext(), creampastaActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "크림 새우") {
                    Intent intent = new Intent(getContext(), creamshrimpActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "치즈 라볶이") {
                    Intent intent = new Intent(getContext(), cheeserabokeeActivity.class);
                    startActivity(intent);
                }

            }
        });

        return rootView;
    }

    public void InitializeRecipeData()
    {
        recipeList = new ArrayList<SampleData>();

        recipeList.add(new SampleData(R.drawable.food_kimchirice, "베이컨 김치볶음밥","베이컨 4줄, 신김치 1컵, 대파 1/2대,  밥 한공기, 진간장 1스푼"));
        recipeList.add(new SampleData(R.drawable.food_kimchinoodle, "김치칼국수","칼국수면 1인분, 김치 1/2컵, 김치국물 1/4컵, 멸치 다시 육수 5~6컵, 만두 4개, 국간장 1/2스푼, 다진마늘 1/4스푼"));
        recipeList.add(new SampleData(R.drawable.food_kimchizzigae, "참치 김치찌개","신김치 1/4포기, 양파 반개, 대파 1대, 청양고추 1개, 참치 100g 1캔, 올리브유 1스푼, 고춧가루 1작은술, 설탕 0.5큰술, 육수 700~700ml"));
        recipeList.add(new SampleData(R.drawable.food_creampasta, "베이컨 크림파스타","마늘 7~8알, 양파 반개, 베이컨 200g, 양송이버섯 5~6개 슬라이스, 파스타면 2인분, 올리브오일, 허브솔트, 시판 크림파스타소스 200g, 우유 100ml"));
        recipeList.add(new SampleData(R.drawable.food_creamshrimp, "크림 새우","새우, 치커리, 튀김가루 1컵, 올리브오일 30g, 식용유, 마요네즈, 식초, 설탕"));
        recipeList.add(new SampleData(R.drawable.food_cheeserabokee, "치즈 라볶이","라면한봉지, 떡국떡한줌, 어묵2장, 치즈1장, 라면스프3/4, 고추장 1.5큰술, 설탕 1.5큰술"));
    }
    @Override
    public void onBackPressed() {
        goToMain();
    }

    private void goToMain() {
        ((MainActivity)getActivity()).replace(ContentFragment.newInstance(res));

    }

}