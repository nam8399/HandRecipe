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
import recipeinhand.com.sidemenu.sample.recipe.food.kimchinoodleActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchiriceActivity;
import recipeinhand.com.sidemenu.sample.recipe.food.kimchizzigaeActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DietFragment extends Fragment implements onBackPressedListener {
    public static final String RICE = "Rice";
    protected int res;
    public static final String CAKE = "Fastfood";

    ArrayList<SampleData> recipeList;

    public static DietFragment newInstance(int resId) {
        DietFragment dietFragment = new DietFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        dietFragment.setArguments(bundle);
        return dietFragment;
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
        View rootView = inflater.inflate(R.layout.fragment_diet, container, false);

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

                if (myAdapter.getItem(position).getTitle() == "김치칼국수") {
                    Intent intent = new Intent(getContext(), kimchinoodleActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "김치볶음밥") {
                    Intent intent = new Intent(getContext(), kimchiriceActivity.class);
                    startActivity(intent);
                }
                if (myAdapter.getItem(position).getTitle() == "김치찌개") {
                    Intent intent = new Intent(getContext(), kimchizzigaeActivity.class);
                    startActivity(intent);
                }

            }
        });

        return rootView;
    }

    public void InitializeRecipeData()
    {
        recipeList = new ArrayList<SampleData>();

        recipeList.add(new SampleData(R.drawable.food_kimchinoodle, "김치칼국수","김치랑 칼국수"));
        recipeList.add(new SampleData(R.drawable.food_kimchirice, "김치볶음밥","김치랑 볶음밥"));
        recipeList.add(new SampleData(R.drawable.food_kimchizzigae, "김치찌개","김치랑 물"));
    }
    @Override
    public void onBackPressed() {
        goToMain();
    }

    private void goToMain() {
        ((MainActivity)getActivity()).replace(ContentFragment.newInstance(res));

    }

}