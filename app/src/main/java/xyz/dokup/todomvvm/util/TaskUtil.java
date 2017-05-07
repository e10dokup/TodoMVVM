package xyz.dokup.todomvvm.util;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * Created by e10dokup on 2017/05/07.
 */

public class TaskUtil {

    private static final DateTimeFormatter PARSE_FORMATTER = DateTimeFormatter.ofPattern("uuuuMMdd");
    private static final DateTimeFormatter DECODE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static long parseDeadline(String deadline) {
        LocalDate localDate = LocalDate.parse(deadline, PARSE_FORMATTER);
        return localDate.atStartOfDay().toEpochSecond(ZoneId.systemDefault().getRules().getOffset(Instant.EPOCH));
    }

    public static String decodeDeadline(long deadlineEpoch) {
        Instant instant = Instant.ofEpochSecond(deadlineEpoch);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return DECODE_FORMATTER.format(localDateTime);
    }

}
