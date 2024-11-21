package br.uam.sdm.config;

import br.uam.sdm.entities.Pizza;
import br.uam.sdm.entities.Subscription;
import br.uam.sdm.entities.User;
import br.uam.sdm.repositories.PizzaRepository;
import br.uam.sdm.repositories.SubscriptionRepository;
import br.uam.sdm.repositories.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Subscription bronze = new Subscription(null, "Plano Bronze", 39.99);
        Subscription prata = new Subscription(null, "Plano Prata", 59.99);
        Subscription ouro = new Subscription(null, "Plano Ouro", 79.99);
        Subscription premium = new Subscription(null, "Plano Premium", 99.99);

        subscriptionRepository.saveAll(Arrays.asList(bronze, prata, ouro, premium));

        User jose = new User(null, "José", "jose@email.com", "senha123", bronze);
        User maria = new User(null, "Maria", "maria@email.com", "senha123", prata);
        User pedro = new User(null, "Pedro", "pedro@email.com", "senha123", ouro);
        User ana = new User(null, "Ana", "ana@email.com", "senha123", premium);
        User carlos = new User(null, "Carlos", "carlos@email.com", "senha123", null);
        User joana = new User(null, "Joana", "joana@email.com", "senha123", bronze);
        User rafael = new User(null, "Rafael", "rafael@email.com", "senha123", prata);
        User fernanda = new User(null, "Fernanda", "fernanda@email.com", "senha123", ouro);
        User lucas = new User(null, "Lucas", "lucas@email.com", "senha123", premium);

        userRepository.saveAll(Arrays.asList(jose, maria, pedro, ana, carlos, joana, rafael, fernanda, lucas));

        Pizza marguerita = new Pizza(null, "Marguerita", "Pizza clássica com tomates, mussarela e manjericão", 35.00);
        Pizza calabresa = new Pizza(null, "Calabresa", "Pizza com fatias de calabresa e cebola", 40.00);
        Pizza portuguesa = new Pizza(null, "Portuguesa", "Pizza com presunto, ovos, cebola e azeitonas", 45.00);
        Pizza quatroQueijos = new Pizza(null, "Quatro Queijos", "Pizza com uma combinação de quatro queijos", 50.00);
        Pizza frangoCatupiry = new Pizza(null, "Frango com Catupiry", "Pizza de frango desfiado com catupiry", 42.00);
        Pizza vegetariana = new Pizza(null, "Vegetariana", "Pizza com vegetais frescos e queijo mussarela", 38.00);

        pizzaRepository.saveAll(Arrays.asList(marguerita, calabresa, portuguesa, quatroQueijos, frangoCatupiry, vegetariana));
    }
}
