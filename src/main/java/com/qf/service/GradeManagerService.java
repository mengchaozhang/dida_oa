package com.qf.service;

import com.qf.pojo.Grade;

import java.util.List;

public interface GradeManagerService {
    List<Grade> getGradeListByCid(int cid);

    int updateScoreBySidAndStage1(String score, int sid);

    int updateScoreBySidAndStage2(String score, int sid);

    int updateScoreBySidAndStage3(String score, int sid);

    int updateScoreBySidAndStage4(String score, int sid);

    Grade getGradeBySid(int sid);

    Grade getGradeAvgByCid(int cid);
}
