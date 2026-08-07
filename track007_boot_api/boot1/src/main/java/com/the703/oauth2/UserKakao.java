package com.the703.oauth2;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor // 모든 필드를 생성자로부터 받기- 컴파일시점에서 자동생성
public class UserKakao implements UserInfoOAuth2 {
	private final Map<String, Object> attributes; // @Autowired - 생성자찾아서 di

	@SuppressWarnings("unchecked")
	private final Map<String, Object> getAccount() {
		Object account = attributes.get("kakao_account");
		return account instanceof Map ? (Map<String, Object>) account : null;
	}

	@Override
	public String getProvider() {

		return "kakao";
	}

	@Override
	public String getProviderId() {
		Object id = attributes.get("id");
		return id != null ? id.toString() : null;
	}

	@Override
	public String getEmail() {
		Map<String, Object> account = getAccount();
		return account != null ? String.valueOf(account.get("email")) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getNickname() {
		// profile={nickname=효정}
		Map<String, Object> account = getAccount();
		Object profile = account.get("profile");
		Map<String, Object> nickname = (Map<String, Object>) profile;
		return String.valueOf(nickname.get("nickname"));
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getImage() {
		Map<String, Object> account = getAccount();
		Object profileObj = account.get("profile");
		Map<String, Object> profile = (Map<String, Object>) profileObj;
		Object imageUrl = profile.get("profile_image_url");
		return imageUrl != null ? imageUrl.toString() : null;
	}
}
