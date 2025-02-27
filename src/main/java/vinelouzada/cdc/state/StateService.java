package vinelouzada.cdc.state;

import org.springframework.stereotype.Service;

@Service
public class StateService {

    private final StateRepository statesRepository;

    public StateService(StateRepository statesRepository) {
        this.statesRepository = statesRepository;
    }

   public State save(State state) {
        if (statesRepository.existsByName((state.getName()))) throw new IllegalArgumentException("Name already exists");

        return statesRepository.save(state);
   }
}
