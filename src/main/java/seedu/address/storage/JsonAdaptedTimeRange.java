package seedu.address.storage;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.util.TimeRange;
import seedu.address.model.util.TimeRange;
import seedu.address.model.customer.Address;
import seedu.address.model.customer.Email;
import seedu.address.model.customer.Name;
import seedu.address.model.customer.Customer;
import seedu.address.model.customer.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.TimeRange;

/**
 * Jackson-friendly version of {@link Customer}.
 */
class JsonAdaptedTimeRange {

    public static String MISSING_FIELD_MESSAGE_FORMAT = "Time Range's %s field is missing!";

    private final LocalTime startTime;
    private final LocalTime endTime;
    /**
     * Constructs a {@code JsonAdaptedCustomer} with the given customer details.
     */
    @JsonCreator
    public JsonAdaptedTimeRange(@JsonProperty("startTime") LocalTime startTime,
                                  @JsonProperty("endTime") LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Converts a given {@code Customer} into this class for Jackson use.
     */
    public JsonAdaptedTimeRange(TimeRange source) {
        startTime = source.getStartTime();
        endTime = source.getEndTime();
    }

    /**
     * Converts this Jackson-friendly adapted customer object into the model's {@code Customer} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted customer.
     */
    public TimeRange toModelType() throws IllegalValueException {

        if (startTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "start time"));
        }

        if (startTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "end time"));
        }

        return new TimeRange(startTime.getHour(), endTime.getHour());
    }

}
