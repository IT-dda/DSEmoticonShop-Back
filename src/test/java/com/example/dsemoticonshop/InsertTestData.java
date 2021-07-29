package com.example.dsemoticonshop;

import com.example.dsemoticonshop.entity.*;
import com.example.dsemoticonshop.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class InsertTestData {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EmoticonRepository emoticonRepository;

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private GroupEmoticonRepository groupEmoticonRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertUser() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            User user = User.builder()
                    .user_id(i)
                    .user_name("user" + i)
                    .email("user" + i + "@ds.com")
                    .hasProfile(false)
                    .build();
            userRepository.save(user);
        });

    }

    @Test
    public void insertCategory() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Category category = Category.builder()
                    .category_id(i)
                    .category_name("category" + i)
                    .build();
            categoryRepository.save(category);
        });
    }

    @Test
    public void insertGroup() {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            int num = (i + 1) / 2;
            Optional<Category> c = categoryRepository.findById(num);
            c.orElse(null);
            Group group = Group.builder()
                    .group_id(i)
                    .group_name("group" + i)
                    .category_id(c.get())
                    .build();
            groupRepository.save(group);
        });
    }

    @Test
    public void insertEmoticon() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Optional<User> u = userRepository.findById(i);
            u.orElse(null);
            Emoticon emoticon = Emoticon.builder()
                    .emoticon_id(i)
                    .emoticon_name("emoticon" + i)
                    .emoticon_price((i % 2 == 0) ? 2500 : 3750)
                    .sale_price((i % 2 == 0) ? 2500 : 3750)
                    .quantity(1)
                    .creator(u.get())
                    .register_date(LocalDateTime.now())
                    .build();
            emoticonRepository.save(emoticon);
        });
    }

    @Test
    public void insertGroupEmoticon() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Optional<Group> g = groupRepository.findById(i % 20 + 1);
            g.orElse(null);
            Optional<Emoticon> e = emoticonRepository.findById(i);
            e.orElse(null);
            GroupEmoticon ge = GroupEmoticon.builder()
                    .id(i)
                    .group_id(g.get())
                    .emoticon_id(e.get())
                    .build();
            groupEmoticonRepository.save(ge);
        });
    }

    @Test
    public void insertOrder() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Optional<User> u = userRepository.findById(i);
            u.orElse(null);
            Optional<Emoticon> e = emoticonRepository.findById(i);
            e.orElse(null);
            Order order = Order.builder()
                    .order_id(i)
                    .order_date(LocalDateTime.now())
                    .method("카카오페이 머니")
                    .order_price(e.get().getSale_price())
                    .emoticon_id(e.get())
                    .purchaser(u.get())
                    .build();
            orderRepository.save(order);
        });
    }

    @Test
    public void insertCoupon() {
        IntStream.rangeClosed(1, 50).forEach(i -> {
            Optional<User> u = userRepository.findById(i);
            u.orElse(null);
            Coupon coupon = Coupon.builder()
                    .coupon_id(i)
                    .coupon_name("coupon" + i)
                    .expired_date(LocalDateTime.now().plusDays(7))
                    .used_date((i < 26) ? LocalDateTime.now() : null)
                    .isUsed(i < 26)
                    .percentage(20)
                    .user_id(u.get())
                    .build();
            couponRepository.save(coupon);
        });
    }

    @Test
    public void insertGift() {
        IntStream.rangeClosed(51, 75).forEach(i -> {
            Optional<Emoticon> e = emoticonRepository.findById(i);
            e.orElse(null);
            Optional<User> u1 = userRepository.findById(i);
            u1.orElse(null);
            Optional<User> u2 = userRepository.findById(i + 25);
            u2.orElse(null);
            Gift gift = Gift.builder()
                    .gift_id(i - 50)
                    .order_date(LocalDateTime.now())
                    .method("카카오페이 머니")
                    .order_price(e.get().getSale_price())
                    .emoticon_id(e.get())
                    .from_id(u1.get())
                    .to_id(u2.get())
                    .code(UUID.randomUUID().toString().substring(9,23).toUpperCase())
                    .build();
            giftRepository.save(gift);
        });
    }

    @Test
    public void insertLike() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Optional<User> u = userRepository.findById(i);
            u.orElse(null);
            Optional<Emoticon> e = emoticonRepository.findById(i);
            e.orElse(null);
            Like like = Like.builder()
                    .like_id(i)
                    .user_id(u.get())
                    .emoticon_id(e.get())
                    .build();
            likeRepository.save(like);
        });
    }

    @Test
    public void testRead() {

        Optional<User> user = userRepository.findById(1);
        System.out.println(user.get());

        Optional<Category> category = categoryRepository.findById(1);
        System.out.println(category.get());

        Optional<Group> group = groupRepository.findById(1);
        System.out.println(group.get());

        Optional<Emoticon> emoticon = emoticonRepository.findById(1);
        System.out.println(emoticon.get());

        Optional<GroupEmoticon> groupEmoticon = groupEmoticonRepository.findById(1);
        System.out.println(groupEmoticon.get());

        Optional<Order> order = orderRepository.findById(1);
        System.out.println(order.get());

        Optional<Coupon> coupon = couponRepository.findById(1);
        System.out.println(coupon.get());

        Optional<Gift> gift = giftRepository.findById(1);
        System.out.println(gift.get());

        Optional<Like> like = likeRepository.findById(1);
        System.out.println(like.get());

    }
}
