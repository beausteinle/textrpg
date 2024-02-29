pragma foreign_keys = on
;

create table if not exists
  region (
    region_id integer primary key,
    name text,
    description text
  )
;

create table if not exists
  scene (
    scene_id integer primary key,
    region_id integer,
    x_location integer,
    y_location integer,
    title text,
    description text,
    foreign key (region_id) references region (region_id)
  )
;

create table if not exists
  character_state (
    character_state_id integer primary key,
    current_region_id integer,
    x_location integer,
    y_location integer
  )
;

create table if not exists
  world_state (
    world_state_id integer primary key,
    character_state_id integer,
    foreign key (character_state_id) references character_state (character_state)
  )
;

create table if not exists
  action_type (
    action_type_id integer primary key,
    action_type text not null
  )
;

create table if not exists
  action (
    action_id integer primary key,
    scene_id integer,
    description text,
    outcome text,
    foreign key (scene_id) references scene (scene_id)
  )
;

insert into
  action_type (action_type)
values
  ('NAVIGATION'),
  ('EVENT_TRIGGER')
;