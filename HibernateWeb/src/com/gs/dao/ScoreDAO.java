package com.gs.dao;

import com.gs.bean.Score;

public interface ScoreDAO {
	
	public Score query(int stuId, int courseId);

}
