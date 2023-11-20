package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class User {
	public User() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	private Integer id;
	private String loginId;
	private String loginPass;
	private String name;

}
