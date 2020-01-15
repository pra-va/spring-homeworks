package it.akademija;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { App.class })
public class UserControllerIT {
//	private static final String URI = "/api/users";
//
//	@Autowired
//	private TestRestTemplate rest;
//
//	@Test
//	public void createsUserThenRetrievesUserListAndDeletesUser() {
//		final String username = "testUsername";
//		final CreateUserCommand createUser = new CreateUserCommand();
//		createUser.setUsername(username);
//		rest.postForLocation(URI, createUser);
//		List<User> users = rest.getForEntity(URI, List.class).getBody();
//		Assert.assertThat(users.size(), CoreMatchers.is(users.size() + 1));
////		assertEquals(users.size(), 1);
//		rest.delete(URI + "/" + username);
//		users = rest.getForEntity(URI, List.class).getBody();
//		Assert.assertThat(users.size(), CoreMatchers.is(0));
////		assertEquals(users.size(), 0);
//	}
}
