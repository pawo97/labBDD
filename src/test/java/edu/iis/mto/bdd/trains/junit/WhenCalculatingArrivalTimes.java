package edu.iis.mto.bdd.trains.junit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.bdd.trains.model.Line;
import edu.iis.mto.bdd.trains.services.BasicItineraryService;
import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;

public class WhenCalculatingArrivalTimes {

    public InMemoryTimetableService timetableService = mock(InMemoryTimetableService.class);
    public BasicItineraryService intineraryService;

    @Before
    public void setUp() {
        intineraryService = new BasicItineraryService(timetableService);
    }

    @Test
    public void isReturnedCorrectInformationAboutTrains() {
        Line line = Line.named("Western")
                        .departingFrom("Emu Plains");
        List<Line> lines = new ArrayList<>();
        lines.add(line);

        when(timetableService.findLinesThrough("Parramatta", "Town Hall")).thenReturn(lines);
        // List<LocalTime> times = timetableService.findArrivalTimes(line, targetStation);
        List<LocalTime> times = new ArrayList<>();
        times.add(new LocalTime(8, 2));
        times.add(new LocalTime(8, 11));
        times.add(new LocalTime(8, 14));
        times.add(new LocalTime(8, 21));
        when(timetableService.findArrivalTimes(line, "Parramatta")).thenReturn(times);

        List<LocalTime> proposedTrainTimes = BasicItineraryService.findNextDepartures("Parramatta", "Town Hall", new LocalTime(8, 00));
        assertThat(proposedTrainTimes, equalTo(times));
    }

}
