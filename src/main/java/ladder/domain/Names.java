package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import ladder.dto.NamesDto;
import ladder.util.StringSplitter;

public class Names {

    private static final Pattern NAMES_FORMAT = Pattern.compile("[^,]+(,[^,]+)+");

    private final List<Name> nameList;

    public Names(String nameList) {
        validateNames(nameList);

        this.nameList = StringSplitter.split(nameList, ",")
            .stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    public Names(String nameList, int expectedCount) {
        validateNames(nameList);

        this.nameList = StringSplitter.split(nameList, ",")
            .stream()
            .map(Name::new)
            .collect(Collectors.toList());

        validateNamesCount(expectedCount);
    }

    private void validateNames(String names) {
        validateNull(names);
        validateFormat(names);
    }

    private void validateNull(String names) {
        if (names == null) {
            throw new IllegalArgumentException("아무 값도 입력되지 않았습니다.");
        }
    }

    private void validateFormat(String names) {
        if (!NAMES_FORMAT.matcher(names).matches()) {
            throw new IllegalArgumentException("이름이 형식과 맞지 않습니다");
        }
    }

    private void validateNamesCount(int expectedCount) {
        if (this.nameList.size() != expectedCount) {
            throw new IllegalArgumentException(
                String.format("입력하는 이름의 개수는 %d와 같아야 합니다.(입력된 이름의 수 : %d)",
                    expectedCount, this.nameList.size()));
        }
    }

    public int findNamesCount() {
        return nameList.size();
    }

    public Name findNameByIndex(int index) {
        return nameList.get(index);
    }

    public boolean contains(String name) {
        return nameList.stream().anyMatch((el) -> el.isEqual(name));
    }

    public Name findName(String name) throws IllegalArgumentException {
        return nameList.stream()
            .filter((el) -> el.isEqual(name))
            .findFirst().orElseThrow(
                () -> new IllegalArgumentException("찾으려는 이름이 이름 목록에 존재하지 않습니다."));
    }

    public NamesDto toDto() {
        return new NamesDto(nameList.stream()
            .map(Name::toDto)
            .collect(Collectors.toList()));
    }
}
