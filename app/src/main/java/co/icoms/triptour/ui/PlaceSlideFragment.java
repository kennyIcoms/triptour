package co.icoms.triptour.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

import co.icoms.triptour.R;
import co.icoms.triptour.utils.MySingleton;

public class PlaceSlideFragment extends Fragment {

    private static final String URL = "url";
    private static final String INDEX = "index";

    private String url;
    private int index;
    private String place;

    public static PlaceSlideFragment newInstance(String url, int index, String place) {

        // Instantiate a new fragment
        PlaceSlideFragment fragment = new PlaceSlideFragment();

        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putString(URL, url);
        bundle.putInt(INDEX, index);
        bundle.putString("place", place);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load parameters when the initial creation of the fragment is done
        this.url = (getArguments() != null) ? getArguments().getString(
                URL) : "http://news.aroundcommodities.com/assets/backgrounds/photo-default-th.png";
        this.index = (getArguments() != null) ? getArguments().getInt(INDEX)
                : -1;
        this.place=(getArguments() != null) ? getArguments().getString("place")
                : "roatan";

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_place_slide, container, false);

        ImageLoader mImageLoader;
        ImageView mImageView;

        // The URL for the image that is being loaded.
        final String IMAGE_URL = new String(url);
        mImageView = (ImageView) rootView.findViewById(R.id.imageView);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getContext(), MainActivity.class);
                mainIntent.putExtra("place", place);
                startActivity(mainIntent);
            }
        });

        // Get the ImageLoader through your singleton class.
        mImageLoader = MySingleton.getInstance(getContext()).getImageLoader();
        mImageLoader.get(IMAGE_URL, ImageLoader.getImageListener(mImageView,
                R.mipmap.def_image, R.mipmap.err_image));

        return rootView;
    }
}
