package com.railway.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.railway.model.Train;
import com.railway.repository.TrainRepository;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List < Train > getAllTrains() {
        return trainRepository.findAll();
    }

    @Override
    public void saveTrain(Train train) {
        this.trainRepository.save(train);

    }

    @Override
    public Train getTrainById(long trainNo) {
        Optional < Train > optional = trainRepository.findById(trainNo);
        Train train = null;
        if (optional.isPresent()) {
            train = optional.get();
        } else {
            throw new RuntimeException("Train is not found for this number ::" + trainNo);
        }
        return train;
    }

    @Override
    public void deleteTrainById(long tainNo) {
        this.trainRepository.deleteById(tainNo);

    }

}