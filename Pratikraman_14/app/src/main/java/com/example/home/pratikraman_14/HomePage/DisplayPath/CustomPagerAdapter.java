package com.example.home.pratikraman_14.HomePage.DisplayPath;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.home.pratikraman_14.HomePage.Path;
import com.example.home.pratikraman_14.R;

import java.util.ArrayList;

class CustomPagerAdapter extends RecyclerView.Adapter<CustomPagerAdapter.MyViewHolder> {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<Path> completeList;
    private static int selectedItem = -1;



    public CustomPagerAdapter(Context context, ArrayList<Path> completeList ){
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.completeList = completeList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public Button playPause;
        public SeekBar seekbar;
        private double startTime = 0;
        private double finalTime = 0;
        private Handler handler;
        int songDuration = 0;
        public MediaPlayer mediaPlayer;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.textViewPath);
            playPause = (Button)itemView.findViewById(R.id.play);
            seekbar = (SeekBar)itemView.findViewById(R.id.seekbar);

        }
        private void initializeStartElements(final int file) {
            ((DisplayPathActivity)mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (null != mediaPlayer) {
                            if (mediaPlayer.isPlaying()) {
                                mediaPlayer.stop();
                                playPause.setBackgroundResource(R.drawable.play_button);
                            }
                        }
                        initializeMediaPlayer(file);
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        private void initializeMediaPlayer(int file) {
//        int id = getApplicationContext().getResources().getIdentifier(songListItemVO.songName, "raw", getApplicationContext().getPackageName());
            mediaPlayer = MediaPlayer.create(mContext,file);
            songDuration = mediaPlayer.getDuration();
            seekbar.setMax(mediaPlayer.getDuration());
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        mediaPlayer.seekTo(progress);
                    } else {
                        seekbar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


        }

        private void StartSongInMediaPlayer() {
            this.mediaPlayer.start();
            playPause.setBackgroundResource(R.drawable.play_button);

            finalTime = mediaPlayer.getDuration();
            startTime = mediaPlayer.getCurrentPosition();
            seekbar.setProgress((int) startTime);
            handler.postDelayed(UpdateSongTime, 100);
        }


        private Runnable UpdateSongTime = new Runnable() {
            @Override
            public void run() {
                seekUpdation();
            }
        };

        public void seekUpdation() {
//        startTime = mediaPlayer.getCurrentPosition();
//        seekbar.setProgress((int) startTime);
//        myHandler.postDelayed(this, 100);

            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(UpdateSongTime, 1000);
        }


        private void registerOnClickListeners() {
            playPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getContext(),"hdfhdjkghkjf",Toast.LENGTH_LONG);
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        playPause.setBackgroundResource(R.drawable.pause_button);

                    } else {
                        StartSongInMediaPlayer();
                    }
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pager_item, parent, false);

        return new MyViewHolder(itemView);
    }
    public void setSelectedItem(int position)
    {
        selectedItem = position;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(selectedItem == position)
            holder.itemView.setSelected(true);
        holder.tv.setText(completeList.get(position).getDescription());
        holder.handler = new Handler();
        holder.registerOnClickListeners();
//            currentSongListItemVO = (SongVO) getIntent().getSerializableExtra(Constants.SONG_OBJECT);
        holder.initializeStartElements(completeList.get(position).getMusicFile());
//        Movie movie = moviesList.get(position);
//        holder.title.setText(movie.getTitle());
//        holder.genre.setText(movie.getGenre());
//        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return completeList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

//    @Override
//    public int getCount() {
//        return completeList.size();
//    }

//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == ((LinearLayout) object);
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
//
//        tv = (TextView) itemView.findViewById(R.id.textViewPath);
//        tv.setText(completeList.get(position).getDescription());
//        playPause = (Button)itemView.findViewById(R.id.play);
//        seekbar = (SeekBar)itemView.findViewById(R.id.seekbar);
//        handler = new Handler();
//        registerOnClickListeners();
////            currentSongListItemVO = (SongVO) getIntent().getSerializableExtra(Constants.SONG_OBJECT);
//        initializeStartElements(completeList.get(position).getMusicFile());
//        container.addView(itemView);
//        return itemView;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView((View) object);
//
//    }
//
//    public int getItemPosition(Object object) {
//        return POSITION_UNCHANGED;
//    }
//
//



//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mediaPlayer.release();
//        if (null != handler) {
//            handler.removeCallbacks(UpdateSongTime);
//            handler = null;
//        }
//    }
}