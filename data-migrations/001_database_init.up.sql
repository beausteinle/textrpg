DROP TABLE IF EXISTS action_type;

CREATE TABLE action_type (action_type_id INTEGER PRIMARY KEY, action_type text NOT NULL);

INSERT INTO action_type(action_type)
VALUES ('NAVIGATION'), ('EVENT_TRIGGER');

INSERT INTO scene (scene_id, region_id, title, description)
VALUES
    (1, 1, 'Starting House', 'You stand at the threshold of your humble abode, a rustic cabin nestled deep within the heart of the forest. Sunlight filters through the dense canopy overhead, dappling the forest floor with patches of golden light.'),
    (2, 1, 'Forest Clearing', 'A tranquil clearing bathed in dappled sunlight lies within the embrace of the forest. Tall trees surround you, their leaves whispering in the breeze, and a carpet of wildflowers blooms at your feet.'),
    (3, 1, 'Riverbank', 'The gentle murmur of a meandering stream soothes your senses as you stand on its grassy banks. Overhanging branches provide shade from the midday sun, and the cool water beckons you to dip your toes in its refreshing embrace.'),
    (4, 1, 'Cave Entrance', 'A gaping maw in the side of a rocky outcrop marks the entrance to a mysterious cave system hidden within the depths of the forest. Cool air wafts from within, carrying with it the scent of damp earth and adventure.'),
    (5, 1, 'Old Growth Grove', 'Ancient trees tower overhead, their gnarled branches forming a canopy so dense that little light penetrates to the forest floor. Moss-covered roots twist and coil around massive boulders, hinting at the forest''s primordial origins.'),
    (6, 1, 'Wildlife Clearing', 'The forest comes alive with the sights and sounds of nature in this bustling clearing. Deer graze peacefully among the ferns, birds flit from branch to branch, and squirrels scamper playfully around the trunks of towering trees.'),
    (7, 1, 'Herbalist''s Hut', 'A quaint wooden hut sits nestled among the trees, its walls adorned with bundles of drying herbs and potted plants. The scent of medicinal plants hangs heavy in the air, and the sound of bubbling cauldrons emanates from within.'),
    (8, 1, 'Treehouse Village', 'Wooden platforms and rope bridges crisscross between the branches of towering trees, forming a treetop village high above the forest floor. Lanterns sway gently in the breeze, casting a warm glow over the rustic dwellings below.'),
    (9, 1, 'Mystic Ruins', 'Ancient stone ruins peek out from beneath a blanket of moss and ivy, hinting at a long-forgotten civilization that once thrived within the heart of the forest. Symbols etched into weathered stone whisper secrets of times long past.');

