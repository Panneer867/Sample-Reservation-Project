package com.railway.service;

import java.util.List;

import com.railway.model.Train;

public interface TrainService {

    List < Train > getAllTrains();
    void saveTrain(Train train);
    Train getTrainById(long trainNo);
    void deleteTrainById(long tainNo);

}