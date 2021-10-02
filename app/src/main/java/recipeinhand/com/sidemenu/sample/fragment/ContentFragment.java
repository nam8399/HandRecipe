package recipeinhand.com.sidemenu.sample.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import recipeinhand.com.sidemenu.interfaces.ScreenShotable;
import recipeinhand.com.sidemenu.sample.MainActivity;
import recipeinhand.com.sidemenu.sample.MyListDecoration;
import recipeinhand.com.sidemenu.sample.OnPersonItemClickListener;
import recipeinhand.com.sidemenu.sample.R;
import recipeinhand.com.sidemenu.sample.ReportFragment;
import recipeinhand.com.sidemenu.sample.SearchActivity;
import recipeinhand.com.sidemenu.sample.VideoData;
import recipeinhand.com.sidemenu.sample.VideoViewAdapter;
import recipeinhand.com.sidemenu.sample.VideoViewHolder;
import recipeinhand.com.sidemenu.sample.WebviewActivity;

/**
 * Created by Konstantin on 22.12.2014.
 */
public class ContentFragment extends Fragment implements ScreenShotable {
    public static final String CLOSE = "Close";
    public static final String SHOP = "Shop";
    public static final String PARTY = "Party";
    public static final String MOVIE = "Movie";
    public static final String HOME = "Home";

    private View containerView;
    protected ImageView mImageView;
    protected int res;
    private Bitmap bitmap;
    ImageView img_drink, img_food, img_fast, img_diet, img_report, gooddata1, gooddata2, gooddata3, gooddata4;
    EditText editText;
    RecyclerView recyclerView;
    VideoViewAdapter adapter;


    Integer arr_random_num[] = new Integer[4];


    public static ContentFragment newInstance(int resId) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        contentFragment.setArguments(bundle);
        return contentFragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //ImageView imageView = (ImageView)rootView.findViewById(R.id.imageview);

        int id = rootView.getId();
        /*
        mImageView = (ImageView) rootView.findViewById(R.id.image_content);
        mImageView.setClickable(true);
        mImageView.setFocusable(true);
        mImageView.setImageResource(res);*/
        gooddata1 = rootView.findViewById(R.id.gooddata1);
        gooddata2 = rootView.findViewById(R.id.gooddata2);
        gooddata3 = rootView.findViewById(R.id.gooddata3);
        gooddata4 = rootView.findViewById(R.id.gooddata4);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            gooddata1.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 40);
                }
            });
            gooddata1.setClipToOutline(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            gooddata2.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 40);
                }
            });
            gooddata2.setClipToOutline(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            gooddata3.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 40);
                }
            });
            gooddata3.setClipToOutline(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            gooddata4.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 40);
                }
            });
            gooddata4.setClipToOutline(true);
        }

        gooddata1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra("onclick", 1);
                startActivity(intent);

            }
        });
        gooddata2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra("onclick", 2);
                startActivity(intent);
            }
        });

        gooddata3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra("onclick", 3);
                startActivity(intent);

            }
        });

        gooddata4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra("onclick", 4);
                startActivity(intent);
            }
        });



        img_drink = rootView.findViewById(R.id.img_drink);
        img_food = rootView.findViewById(R.id.img_food);
        img_fast = rootView.findViewById(R.id.img_desert);
        img_diet = rootView.findViewById(R.id.img_diet);
        img_report = rootView.findViewById(R.id.img_report);
        img_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replace(CoffeeFragment.newInstance(res));
            }
        });

        img_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replace(RiceFragment.newInstance(res));
            }
        });

        img_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replace(DesertFragment.newInstance(res));
            }
        });
        img_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replace(ReportFragment.newInstance(res));
            }
        });


        editText = rootView.findViewById(R.id.edittext);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (KeyEvent.ACTION_UP == keyEvent.getAction()) {
                    switch (i) {
                        case KeyEvent.KEYCODE_ENTER:
                            Intent intent = new Intent(getContext(), SearchActivity.class);
                            intent.putExtra("onclick", editText.getText().toString());
                            startActivity(intent);
                            break;
                    }
                }

                return false;
            }
        });





        Random random = new Random();
        //0~5까지 6개의 숫자중 랜덤발생 +1을 해줘서 1~6으로 바꿈
        int i = 0;
        arr_random_num[i] = random.nextInt(4) + 1;


        int v = arr_random_num[i];




        // Recycler view
        //RecyclerView recyclerView = rootView.findViewById(R.id.list_video);
        // Adapter 추가


        MyListDecoration decoration = new MyListDecoration();
        recyclerView = rootView.findViewById(R.id.list_video);

        recyclerView.addItemDecoration(decoration);



        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new VideoViewAdapter();


        if (v == 1) {
            adapter.addItem(new VideoData(R.drawable.todaycook_ramen, 1));
            adapter.addItem(new VideoData(R.drawable.todaycook_eggfood, 2));
            adapter.addItem(new VideoData(R.drawable.todaycook_spam, 3));
            adapter.addItem(new VideoData(R.drawable.todaycook_shrimp, 4));

        }
        else if (v == 2) {
            adapter.addItem(new VideoData(R.drawable.todaycook_eggfood, 2));
            adapter.addItem(new VideoData(R.drawable.todaycook_spam, 3));
            adapter.addItem(new VideoData(R.drawable.todaycook_shrimp, 4));
            adapter.addItem(new VideoData(R.drawable.todaycook_ramen, 1));
        }
        else if (v == 3) {
            adapter.addItem(new VideoData(R.drawable.todaycook_spam, 3));
            adapter.addItem(new VideoData(R.drawable.todaycook_shrimp, 4));
            adapter.addItem(new VideoData(R.drawable.todaycook_ramen, 1));
            adapter.addItem(new VideoData(R.drawable.todaycook_eggfood, 2));
        }
        else if (v == 4) {
            adapter.addItem(new VideoData(R.drawable.todaycook_shrimp, 4));
            adapter.addItem(new VideoData(R.drawable.todaycook_ramen, 1));
            adapter.addItem(new VideoData(R.drawable.todaycook_eggfood, 2));
            adapter.addItem(new VideoData(R.drawable.todaycook_spam, 3));
        }

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClicklistener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(VideoViewHolder holder, View view, int position) {
                VideoData item = adapter.getitem(position);

                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra("Key", item.getIdx());
                startActivity(intent);
                //Toast.makeText(getContext(), "아이템선택" + item.getIdx(), Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }








    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void takeScreenShot() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                /*Bitmap bitmap = Bitmap.createBitmap(containerView.getWidth(),
                        containerView.getHeight(), Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(bitmap);
                containerView.draw(canvas);
                ContentFragment.this.bitmap = bitmap;*/
            }
        };

        thread.start();

    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}

