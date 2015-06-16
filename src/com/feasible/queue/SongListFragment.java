package com.feasible.queue;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SongListFragment extends Fragment{
	
	ListView mSongListView;
	ArrayAdapter<Song> mListAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(new Song("Hey now","Madeon")); songs.add(new Song("New home","Madeon"));
		
		mSongListView = (ListView) rootView.findViewById(R.id.songList);
		
		mListAdapter = new ArrayAdapter<Song>( getActivity(), R.layout.song_label_view);
		mListAdapter.addAll(songs);
		mSongListView.setAdapter(mListAdapter);
//		
		return rootView;
	}
	
	
	public void addSong(View view){
		System.out.println("Clicked");
	}
}
