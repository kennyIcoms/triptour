package co.icoms.triptour.data.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import co.icoms.triptour.R;
import co.icoms.triptour.ui.MainActivitiesCell;
import co.icoms.triptour.utils.MySingleton;

public class MainActivitiesAdapter extends RecyclerView.Adapter<MainActivitiesAdapter.ActivitiesViewHolder>{

    public List<MainActivitiesCell> Activities;
    private Context context;

    public MainActivitiesAdapter(List<MainActivitiesCell> Activities, Context context){
        this.Activities = Activities;
        this.context=context;
    }

    @Override
    public ActivitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_main_activities, parent, false);
        ActivitiesViewHolder ActivitiesViewHolder = new ActivitiesViewHolder(view);
        return ActivitiesViewHolder;
    }

    @Override
    public void onBindViewHolder(final ActivitiesViewHolder holder, int position) {
        holder.name.setText(Activities.get(position).getName());

        ImageLoader mImageLoader;

        // Get the ImageLoader through your singleton class.
        mImageLoader = MySingleton.getInstance(this.context).getImageLoader();
        holder.photo.setImageUrl(Activities.get(position).getPhotoUrl(),mImageLoader);

        switch (Activities.get(position).getCalification()){
            case 5:
                holder.star5.setImageResource(R.drawable.star_full);
            case 4:
                holder.star4.setImageResource(R.drawable.star_full);
            case 3:
                holder.star3.setImageResource(R.drawable.star_full);
            case 2:
                holder.star2.setImageResource(R.drawable.star_full);
            case 1:
                holder.star1.setImageResource(R.drawable.star_full);
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return this.Activities.size();
    }

    public static class ActivitiesViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView name;
        NetworkImageView photo;
        TextView price;
        ImageView star1;
        ImageView star2;
        ImageView star3;
        ImageView star4;
        ImageView star5;

        ActivitiesViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            name = (TextView)itemView.findViewById(R.id.name);
            photo = (NetworkImageView)itemView.findViewById(R.id.photo);
            price = (TextView)itemView.findViewById(R.id.price);
            star1 = (ImageView)itemView.findViewById(R.id.star_1);
            star2 = (ImageView)itemView.findViewById(R.id.star_2);
            star3 = (ImageView)itemView.findViewById(R.id.star_3);
            star4 = (ImageView)itemView.findViewById(R.id.star_4);
            star5 = (ImageView)itemView.findViewById(R.id.star_5);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}