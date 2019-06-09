package edu.iis.mto.bdd.trains.services;

import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.LocalTime;

import edu.iis.mto.bdd.trains.model.Line;

public class BasicItineraryService extends JourneyPlan {

    public static InMemoryTimetableService timetableService;

    public BasicItineraryService(InMemoryTimetableService timetableService) {
        this.timetableService = timetableService;
    }

    public static List<LocalTime> findNextDepartures(String departure, String destination, LocalTime departureTime) {
        Line line = timetableService.findLinesThrough(departure, destination)
                                    .get(0);
        return timetableService.findArrivalTimes(line, departure)
                               .stream()
                               .filter(time -> time.isAfter(departureTime) && time.isBefore(departureTime.plusMinutes(30)))
                               .collect(Collectors.toList());
    }
}
