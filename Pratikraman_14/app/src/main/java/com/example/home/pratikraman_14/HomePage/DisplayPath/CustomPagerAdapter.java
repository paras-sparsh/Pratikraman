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
import android.widget.ImageView;
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
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.textViewPath);
            tvTotalTime = (TextView) view.findViewById(R.id.textViewTotalTime);
            tvCurrentTime = (TextView) view.findViewById(R.id.textViewCurrentTime);
            playPause = (Button)itemView.findViewById(R.id.play);
            seekbar = (SeekBar)itemView.findViewById(R.id.seekbar);
            imageView = (ImageView)itemView.findViewById(R.id.ivPosition);
        }

        private void initializeStartElements(final int file) {
            ((DisplayPathActivity)mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {


                        if (null != mediaPlayer) {
                            if(getTimeString(mediaPlayer.getCurrentPosition()).equals(getTimeString(mediaPlayer.getDuration()))){
                                playPause.setBackgroundResource(R.drawable.play_button);
                            }


//                            mediaPlayer = MediaPlayer.create(v.getContext(), mItem.getmSound());
//                            mediaPlayer.start();

//                            else {
//                                playPause.setBackgroundResource(R.drawable.pause_button);
//                            }
                        }
                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                            playPause.setBackgroundResource(R.drawable.play_button);
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            mediaPlayer.release();
                            mediaPlayer = null;
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
            //mediaPlayer.start();
            songDuration = mediaPlayer.getDuration();

            seekbar.setMax(mediaPlayer.getDuration());
            tvCurrentTime.setText(getTimeString(mediaPlayer.getCurrentPosition()));
            tvTotalTime.setText(getTimeString(mediaPlayer.getDuration()));
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        mediaPlayer.seekTo(progress);
                        seekbar.setProgress(progress);
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
            //mediaPlayer.reset();
            mediaPlayer.start();
            playPause.setBackgroundResource(R.drawable.pause_button);

            finalTime = mediaPlayer.getDuration();
            startTime = mediaPlayer.getCurrentPosition();
            seekbar.setProgress((int) startTime);
            tvCurrentTime.setText(getTimeString(mediaPlayer.getCurrentPosition()));
            tvTotalTime.setText(getTimeString(mediaPlayer.getDuration()));
            handler.postDelayed(UpdateSongTime, 100);
        }

        private Runnable UpdateSongTime = new Runnable() {
            @Override
            public void run() {
                seekUpdation();
            }
        };

        public void seekUpdation() {
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            tvCurrentTime.setText(getTimeString(mediaPlayer.getCurrentPosition()));
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

        if(completeList.get(position).getDescription().length() == 0 && completeList.get(position).getTitle().equals("poses")){
            holder.imageView.setImageResource(completeList.get(position).getMusicFile());
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
            holder.tv.setText(completeList.get(position).getDescription());
            holder.handler = new Handler();
            holder.registerOnClickListeners();
            holder.initializeStartElements(completeList.get(position).getMusicFile());
        }

    }

    @Override
    public int getItemCount() {
        return completeList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    private String getTimeString(long millis) {
        StringBuffer buf = new StringBuffer();

        int hours = (int) (millis / (1000 * 60 * 60));
        int minutes = (int) ((millis % (1000 * 60 * 60)) / (1000 * 60));
        int seconds = (int) (((millis % (1000 * 60 * 60)) % (1000 * 60)) / 1000);

        buf
                .append(String.format("%d", minutes))
                .append(":")
                .append(String.format("%02d", seconds));

        return buf.toString();
    }
}