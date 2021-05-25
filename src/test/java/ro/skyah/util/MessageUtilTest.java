package ro.skyah.util;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MessageUtilTest {

    @Test
    public void testNullCrop() {
        String s = null;
        assertNull(MessageUtil.cropS(s));
        assertNull(MessageUtil.cropM(s));
        assertNull(MessageUtil.cropL(s));
        s = "";
        assertTrue(MessageUtil.cropS(s).isEmpty());
    }

    @Test
    public void testCrop() {
        String s = "abc";
        assertEquals(s, MessageUtil.cropS(s));
        assertEquals(s, MessageUtil.cropM(s));
        assertEquals(s, MessageUtil.cropL(s));

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 65535).forEach(i -> sb.append("a"));
        assertEquals(65535, MessageUtil.cropL(sb.toString()).length());
        StringBuilder sb1 = new StringBuilder();
        IntStream.range(0, 65536).forEach(i -> sb1.append("a"));
        assertEquals(1030, MessageUtil.cropL(sb1.toString()).length());
    }
}
