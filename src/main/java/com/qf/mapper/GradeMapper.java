package com.qf.mapper;

import com.qf.pojo.Grade;

import java.util.List;

public interface GradeMapper {
    public List<Grade> getGradeListByCid(int cid);

    public int updateScoreBySidAndStage1(String score, int sid);

    public int updateScoreBySidAndStage2(String score, int sid);

    public int updateScoreBySidAndStage3(String score, int sid);

    public int updateScoreBySidAndStage4(String score, int sid);

    public int insertScoreByStage11(String score, int sid, int cid);

    public int insertScoreByStage1(String score, int sid, int cid);

    public int insertScoreByStage2(String score, int sid, int cid);

    public int insertScoreByStage3(String score, int sid, int cid);

    public int insertScoreByStage4(String score, int sid, int cid);

    public Grade getGradeBySid(int sid);

    public Grade getGradeAvgByCid(int cid);

    public Grade getGradeBySidAndCid(int sid, int cid);
}
