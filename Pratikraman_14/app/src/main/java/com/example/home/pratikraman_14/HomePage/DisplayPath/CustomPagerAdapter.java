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
    public static MediaPlayer mediaPlayer;


    public CustomPagerAdapter(Context context, ArrayList<Path> completeList ){
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.completeList = completeList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv,tvTotalTime, tvCurrentTime;
        public Button playPause;
        public SeekBar seekbar;
        private double startTime = 0;
        private double finalTime = 0;
        private Handler handler;
        int songDuration = 0;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.textViewPath);
            tvTotalTime = (TextView) view.findViewById(R.id.textViewTotalTime);
            tvCurrentTime = (TextView) view.findViewById(R.id.textViewCurrentTime);
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
                                mediaPlayer.reset();
//                                if(playPause.getBackground
//                                        ().equals(R.drawable.play_button)){
//                                    playPause.setBackgroundResource(R.drawable.pause_button);
//                                } else {
//                                    playPause.setBackgroundResource(R.drawable.play_button);
//                                }
                                playPause.setBackgroundResource(R.drawable.play_button);
                            }
                            else {
//                                if(playPause.getBackground().equals(R.drawable.play_button)){
//                                    playPause.setBackgroundResource(R.drawable.pause_button);
//                                } else {
//                                    playPause.setBackgroundResource(R.drawable.play_button);
//                                }
                                playPause.setBackgroundResource(R.drawable.pause_button);
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
            tvTotalTime.setText(songDuration);
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
            mediaPlayer.start();
            playPause.setBackgroundResource(R.drawable.play_button);
//           tvCurrentTime.setText(mediaPlayer.getCurrentPosition());
           // tvTotalTime.setText(mediaPlayer.getDuration());
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
            //tvCurrentTime.setText(mediaPlayer.getCurrentPosition());
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
                        //mediaPlayer.reset();
                        playPause.setBackgroundResource(R.drawable.play_button);
//                        if(playPause.getBackground().equals(R.drawable.play_button)){
//                            playPause.setBackgroundResource(R.drawable.pause_button);
//                        } else {
//                            playPause.setBackgroundResource(R.drawable.play_button);
//                        }
                    } else {
                        StartSongInMediaPlayer();
                        //playPause.setBackgroundResource(R.drawable.play_button);
//                        if(playPause.getBackground().equals(R.drawable.play_button)){
//                            playPause.setBackgroundResource(R.drawable.pause_button);
//                        } else {
//                            playPause.setBackgroundResource(R.drawable.play_button);
//                        }
                    }
                }
            });
        }

//        @Override
//        protected  void onPause(){
//
//        }
//        protected void onDestroy() {
//            super.onPause();
//            if (mediaPlayer != null) {
//                mediaPlayer.pause();
//                if (isFinishing()) {
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                }
//            }
//        }
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
        holder.initializeStartElements(completeList.get(position).getMusicFile());
//        holder.tvCurrentTime.setText(holder.mediaPlayer.getCurrentPosition());
        //holder.tvTotalTime.setText(mediaPlayer.getDuration());
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
//    protected  void onPause(){
//
//    }
}