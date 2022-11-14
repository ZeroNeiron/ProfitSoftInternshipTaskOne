package org.example.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.example.service.TextService;
import org.junit.jupiter.api.Test;

class TextServiceImplTest {
    private final TextService textService = new TextServiceImpl();

    @Test
    void findMostPopularHashtags_validInputData_positive() {
        List<String> list = List.of("#AAA#AAA #BBB #CCC #DDD #EEE#EEE",
                "#AAA #BBB #CCC #DDD#DDD ",
                "#AAA #BBB #CCC#CCC",
                "#AAA #BBB#BBB",
                "#AAA#AAA");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#AAA", 5);
        expected.put("#BBB", 4);
        expected.put("#CCC", 3);
        expected.put("#DDD", 2);
        expected.put("#EEE", 1);

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtags_oneHashtag_positive() {
        List<String> list = List.of("#AAA ASF FDSDF SDF SDFGFS");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#AAA", 1);

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtags_hashtagWithoutLetters_positive() {
        List<String> list = List.of("#");

        Map<String, Integer> expected = Collections.EMPTY_MAP;

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtags_lessThenFiveHashtags_positive() {
        List<String> list = List.of("#AAA#AAA #BBB #CCC",
                "#AAA",
                "#CCC#CCC");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("#CCC", 2);
        expected.put("#AAA", 2);
        expected.put("#BBB", 1);

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtags_emptyList_positive() {
        List<String> list = Collections.EMPTY_LIST;

        Map<String, Integer> expected = Collections.EMPTY_MAP;

        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }

    @Test
    void findMostPopularHashtags_withoutHashtags_positive() {
        List<String> list = List.of("AAA BBB CCC",
                "AAA",
                "CCC CCC");

        Map<String, Integer> expected = Collections.EMPTY_MAP;
        assertEquals(expected.toString(),
                textService.findMostPopularHashtags(list, 5).toString());
    }
}